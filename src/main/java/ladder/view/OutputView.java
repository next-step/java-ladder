package ladder.view;

import ladder.model.*;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static String RUNG = "|-----";
    private static String EMPTY_RUNG = "|     ";
    private static String MARGIN = "    ";
    private static String DELIMITER = "\t";

    public static void print(Players players, Ladder ladder, Rewards rewards) {
        printPlayers(players);
        printLadder(ladder);
        printRewards(rewards);
    }

    private static void printRewards(Rewards rewards) {
        String line = rewards.getRewards().stream()
                .map(Reward::getValue)
                .collect(joining(DELIMITER));

        System.out.println(line);
    }

    private static void printPlayers(Players players) {
        String line = players.getPlayers().stream()
                .map(Player::getName)
                .collect(joining(DELIMITER));

        System.out.println(line);
    }

    private static void printLadder(Ladder ladder) {
        List<Layer> layers = ladder.getLayers();
        for (Layer layer : layers) {
            String line = layer.getDirections().stream()
                    .map(direction -> direction == Direction.RIGHT ? RUNG : EMPTY_RUNG)
                    .collect(joining());

            System.out.println(MARGIN.concat(line));
        }
    }
}
