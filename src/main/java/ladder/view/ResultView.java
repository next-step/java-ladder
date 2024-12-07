package ladder.view;

import ladder.domain.engine.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.engine.Name.DEFAULT_MAX_NAME_LENGTH;

public class ResultView {
    public static final int START_INCLUSIVE = 0;
    public static final String LINE_BREAK = System.lineSeparator();
    public static final String SPACE = " ";
    public static final String SPACES = "     ";
    public static final String CROSS_LINES = "-----";
    public static final String PLAYER_DELIMITER = "|";
    public static final String PREFIX = "";
    public static final int INDEX_OFFSET = 1;
    public static final String RESULT_MESSAGE = "사다리 결과";
    public static final int PLAYER_NAME_SIZE = 1;
    public static final int PLAYER_NAME_INDEX = 0;
    public static final String EXECUTE_RESULTS_MESSAGE = "실행 결과";
    public static final String COLON = " : ";

    public ResultView() {
    }

    public void renderLadderAndRewards(Ladder ladder, Rewards rewards) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(toLadder(ladder, rewards));
    }

    public String toLadder(Ladder ladder, Rewards rewards) {
        Players players = ladder.getPlayers();
        List<Line> lines = ladder.getLines()
                .getLines();
        return toFormattedNames(players) +
                LINE_BREAK +
                toFormattedLines(players, lines) +
                LINE_BREAK +
                toFormattedNames(rewards);
    }

    public void renderResults(Results results, List<PlayerName> playerNames) {
        System.out.println(EXECUTE_RESULTS_MESSAGE);
        if (playerNames.size() == PLAYER_NAME_SIZE) {
            printResult(results, playerNames);
            return;
        }
        printResults(results);
    }

    private static void printResult(Results results, List<PlayerName> playerNames) {
        RewardName result = results.result(playerNames.get(PLAYER_NAME_INDEX));
        System.out.println(result.name());
    }

    private static void printResults(Results results) {
        Map<PlayerName, RewardName> resultsMap = results.results();
        resultsMap.forEach((key, value) -> System.out.println(key.name() + COLON + value.name()));
    }

    private static String toFormattedLines(Players players, List<Line> lines) {
        return lines.stream()
                .map(line -> toFormattedLine(players, line.getPoints()))
                .collect(Collectors.joining(LINE_BREAK));
    }

    private static String toFormattedNames(Players players) {
        return players.names()
                .stream()
                .map(name -> SPACE.repeat(DEFAULT_MAX_NAME_LENGTH - name.length()) + name.name())
                .collect(Collectors.joining(SPACE));
    }

    private static String toFormattedNames(Rewards rewards) {
        return rewards.names()
                .stream()
                .map(name -> SPACE.repeat(DEFAULT_MAX_NAME_LENGTH - name.length()) + name.name())
                .collect(Collectors.joining(SPACE));
    }

    private static String toFormattedLine(Players players, List<Point> points) {
        List<PlayerName> names = players.names();
        return IntStream.range(START_INCLUSIVE, names.size())
                .boxed()
                .map(index -> toFormattedHorizontal(index, points))
                .collect(Collectors.joining(PLAYER_DELIMITER, PREFIX, PLAYER_DELIMITER));
    }

    private static String toFormattedHorizontal(int index, List<Point> points) {
        if (index == START_INCLUSIVE) {
            return SPACES;
        }
        if (points.get(index - INDEX_OFFSET).getRight()) {
            return CROSS_LINES;
        }
        return SPACES;
    }
}
