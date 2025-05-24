package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Property> properties = ConfigLoader.loadConfig("src/gameConfig.txt");
            Board board = new Board(properties);

            List<Player> players = List.of(
                    new Player("Impulsivo", 300, Player.Humor.IMPULSIVE),
                    new Player("Exigente", 300, Player.Humor.DEMANDING),
                    new Player("Cauteloso", 300, Player.Humor.CAREFUL),
                    new Player("Aleatório", 300, Player.Humor.RANDOM)
            );

            Simulation game = new Simulation(board, new ArrayList<>(players));
            game.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
