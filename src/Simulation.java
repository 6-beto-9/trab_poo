package src;

import src.gameExceptions.BankruptException;

import java.util.*;

public class Simulation {
    private Board board;
    private List<Player> players;
    private int maxRounds = 1000;
    private boolean debug = true;  //log

    public Simulation(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        int round = 0;

        while (players.size() > 1 && round < maxRounds) {
            round++;

            if (debug) System.out.println("=== Rodada " + round + " ===");

            Iterator<Player> iterator = players.iterator();

            while (iterator.hasNext()) {
                Player player = iterator.next();

                int dice = rollDice();

                if (debug) {
                    System.out.println(player.getName() + " vai jogar o dado... Tirou: " + dice);
                    System.out.println("Posição antes: " + player.getPosition() + ", Moedas: " + player.getCoins());
                }

                try {
                    player.move(dice, board);  // Chamada corrigida (sem currentProperty)

                    Property currentProperty = board.getSquareAt(player.getPosition()); // agora sim, após o movimento

                    if (debug) {
                        System.out.println(player.getName() + " agora está na posição " + player.getPosition());
                        System.out.println(player.getName() + " tem " + player.getCoins() + " moedas");
                        if (currentProperty.hasOwner()) {
                            System.out.println("A propriedade tem dono: " + currentProperty.getOwner().getName());
                        } else {
                            System.out.println("A propriedade está disponível.");
                        }
                    }
                } catch (BankruptException e) {
                    System.out.println(">>> " + e.getMessage());
                    board.resetPropertiesFrom(player);
                    iterator.remove();
                    if (debug) {
                        System.out.println(player.getName() + " foi removido do jogo por falência.");
                    }
                }

                if (debug) System.out.println();
            }
        }

        //
        if (players.size() == 1) {
            System.out.println("Vencedor: " + players.get(0).getName());
        } else {
            System.out.println("Empate ou limite de rodadas atingido.");
        }
    }

    private int rollDice() {
        return new Random().nextInt(6) + 1;
    }
}
