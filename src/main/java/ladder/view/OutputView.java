package ladder.view;

import ladder.model.Direction;
import ladder.model.Ladder;
import ladder.model.Layer;
import ladder.model.Player;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static String RUNG = "-----|";
    private static String EMPTY_RUNG = "     |";

    public static void print(List<Player> players, Ladder ladder) {
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printPlayers(List<Player> players) {
        String line = players.stream()
                .map(Player::getName)
                .collect(joining("\t"));

        System.out.println(line);
    }

    private static void printLadder(Ladder ladder) {
        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            String line = layer.getDirections().stream()
                    .map(direction -> direction == Direction.RIGHT ? RUNG : EMPTY_RUNG)
                    .collect(joining());

            System.out.println(EMPTY_RUNG.concat(line));
        }
    }
}
