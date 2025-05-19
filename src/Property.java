package src;

public class Property {
    private final int price;
    private final int rent;
    private Player owner;

    public Property(int price, int rent) {
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRent() {
        return this.rent;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean haveOwner() {
        return this.owner != null;
    }

    public void resetOwner() {
            this.owner = null;
    }
}