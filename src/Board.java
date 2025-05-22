package src;

import java.util.List;

public class Board {
    private final List<Property> squares; // ou spaces

    public Board(List<Property> squares) {
        if (squares.size() != 20) {
            throw new IllegalArgumentException("O tabuleiro deve conter exatamente 20 casas.");
        }
        this.squares = squares;
    }

    public Property getSquareAt(int position) {
        return squares.get(position);
    }

    public int getSize() {
        return squares.size();
    }//so pra dizer o tamanho da lista

    public void resetPropertiesFrom(Player player) {
        for (Property property : squares) {
            if (property.getOwner() != null && property.getOwner().equals(player)) {
                property.resetOwner();
            }
        }
    }

    public List<Property> getSquares() {
        return squares;
    }
}
