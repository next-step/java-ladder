package ladder.view;

import ladder.model.Ladder;
import ladder.model.Layer;
import ladder.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static String RUNG = "-----|";
    private static String EMPTY_RUNG = "     |";

    public static void print(List<Player> players, Ladder ladder) {
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printPlayers(List<Player> players) {
        String line = players.stream().map(Player::getName).collect(Collectors.joining("\t"));

        System.out.println(line);
    }

    private static void printLadder(Ladder ladder) {
        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            String line = layer.getRungs().stream().map(rung -> rung.isRung() ? RUNG : EMPTY_RUNG).collect(Collectors.joining());
            System.out.println(EMPTY_RUNG.concat(line));
        }
    }
}
