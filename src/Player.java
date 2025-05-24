package src;

import src.gameExceptions.BankruptException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int position = 0;
    private String name;
    private int coins;
    private Humor humor;
    private final List<Property> properties = new ArrayList<>();

    public Player(String name, int coins, Humor humor) {
        this.name = name;
        this.coins = coins;
        this.humor = humor;
    }

    public enum Humor {
        IMPULSIVE, DEMANDING, CAREFUL, RANDOM
    }

    public void move(int steps, Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }

        int boardSize = board.getSize();
        int destination = (this.position + steps) % boardSize;

        Property destinationProperty = board.getSquareAt(destination);

        if (this.position + steps >= boardSize) {
            this.coins += 100;
        }

        if (destinationProperty.hasOwner() && !destinationProperty.getOwner().equals(this)) {
            this.payPropertyRent(destinationProperty);
        }
        else if (!destinationProperty.hasOwner() && this.chooseIfPurchase(destinationProperty)) {
            this.buyProperty(destinationProperty);
        }

        this.position = destination;
    }



    public void payPropertyRent(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property cannot be null");
        }

        int rent = property.getRent();
        Player owner = property.getOwner();

        this.pay(rent);
        owner.receiveCoins(rent);
    }

    public void receiveCoins(int coins) {
        this.coins += coins;
    }

    private boolean chooseIfPurchase(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property cannot be null");
        }

        return switch (this.humor) {
            case Humor.IMPULSIVE -> true;
            case Humor.DEMANDING -> property.getRent() > 50;
            case Humor.CAREFUL -> coins - property.getPrice() >= 80;
            case Humor.RANDOM -> Math.random() < 0.5;
        };
    }

    private void buyProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property cannot be null");
        }

        int price = property.getPrice();

        this.pay(price);
        this.properties.add(property);
        property.setOwner(this);
    }

    private boolean hasEnoughCoins(int amount) {
        return coins >= amount;
    }

    private void pay(int price) {
        if(!this.hasEnoughCoins(price)) {
            throw new BankruptException(this.name + " Não tem dinheiro suficiente para pagar");
        }

        this.coins = this.coins - price;
    }

    // GETTERS AND SETTERS ========================

    public int getCoins() {
        return coins;
    }

    public Humor getHumor() {
        return humor;
    }

    public void setHumor(Humor humor) {
        this.humor = humor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public int getPosition(){
        return position;
    }
}
