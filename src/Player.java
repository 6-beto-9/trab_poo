package src;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int position;
    private String name;
    private Integer coins = 300;
    private Humor humor;
    private final List<Property> properties = new ArrayList<>();

    public Player(String name, int coins, Humor humor) {
        this.name = name;
        this.coins = coins;
        this.humor = humor;
        this.position = 0;
    }

    public void move(int space, int boardSize){
        int newPosition = this.position + space;
        if(newPosition >= boardSize){
            this.coins += 100;
        }
        this.position = newPosition % boardSize;
    }

    public enum Humor {
        IMPULSIVE, DEMANDING, CAREFUL, RANDOM
    }

    private void buyProperty(Property property) {
        int price = property.getPrice();

        if(!hasEnoughCoins(price)) {
            throw new Error("Jogador " + this.name + " não tem moedas suficiente");
        }

        this.coins = this.coins - price;
        this.properties.add(property);
        property.setOwner(this);
    }

    public void payPropertyRent(Property property) {
        //TODO
    }

    private boolean hasEnoughCoins(int amount) {
        return coins >= amount;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
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
