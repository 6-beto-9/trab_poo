package src;

public class Player {
    private String name;
    private Integer coins = 300;
    private Humor humor;

    public enum Humor {
        IMPULSIVE, DEMANDING, CAREFUL, RANDOM
    }

    private void buyProperty() {

    }

    public void payPropertyRent() {

    }

    private boolean hasEnoughCoins(int amount) {
        return coins >= amount;
    }

//  GETTERS AND SETTERS =========================================

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
}
