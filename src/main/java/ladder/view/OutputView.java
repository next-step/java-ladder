package ladder.view;

import ladder.model.*;

import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static String RUNG = "|-----";
    private static String EMPTY_RUNG = "|     ";
    private static String MARGIN = "    ";
    private static String DELIMITER = "\t";
    private static String RESULT = "실행 결과";

    private static String RESULT_PATTERN = "%s : %s".concat(System.lineSeparator());

    public static void print(Players players, Ladder ladder, Rewards rewards) {
        printPlayers(players);
        printLadder(ladder);
        printRewards(rewards);
        printLineBreak();
    }

    private static void printLineBreak() {
        System.out.println();
        System.out.println();
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

    public static void print(String name, Result result) {
        System.out.println(RESULT);

        if("all".equals(name)) {
            printAllResult(result);
            return;
        }

        printOneResult(name, result);
    }

    private static void printOneResult(String name, Result result) {
        System.out.printf(RESULT_PATTERN, name, result.get(name));
    }

    private static void printAllResult(Result result) {
        Iterator<String> playerNames = result.getAll();
        while(playerNames.hasNext()) {
            String playerName = playerNames.next();
            String reward = result.get(playerName);

            System.out.printf(RESULT_PATTERN, playerName, reward);
        }
    }
}
