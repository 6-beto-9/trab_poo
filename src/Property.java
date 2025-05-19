package src;

public class Property {
    private int price;
    private int rent;
    private Player owner;

    public Property(int price, int rent) {
        this.price = price;
        this.rent = rent;
        this.owner = null;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean haveOwner() {
        return owner != null;
    }

    public void resetOwner() {
            owner = null;
    }
}