package ladder.view;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.result.ExecutionResults;
import ladder.domain.user.Player;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static java.util.stream.Collectors.joining;

public class ResultView {

    public static final String LADDER_MSG = "사다리 결과";
    public static final String RESULT_MSG = "실행 결과";
    public static final String FIVE_SIZE_FORMAT = "%5s";
    public static final String WHITE_SPACE = " ";
    public static final String LADDER_SPACE = "     ";
    public static final String LADDER_LINE = "-----";
    public static final String LADDER_COLUMN = "|";
    public static final String ENTER = "\n";
    public static final String DELIMITER = " : ";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadderResult(List<Player> players, List<Line> ladder) {
        System.out.println(LADDER_MSG);
        System.out.println();
        System.out.println(printPlayerName(players));
        System.out.println(printLadder(ladder));
    }

    public static void printItems(ExecutionResults items) {
        System.out.println(gameItems(items));
        System.out.println();
    }

    public static void printResults(List<String> players, Map<String, String> results) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(gameResults(players, results));
    }

    public static void printSingleResult(String resultItem) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(resultItem);
        System.out.println();
    }

    private static String printPlayerName(List<Player> players) {
        return players.stream()
                .map(player -> String.format(FIVE_SIZE_FORMAT, player.getPlayerName()))
                .collect(joining(WHITE_SPACE));
    }

    public static String printLadder(List<Line> ladder) {
        return ladder.stream()
                .map(ResultView::printLine)
                .collect(joining(ENTER));
    }

    private static String printLine(Line line) {
        StringJoiner joiner = new StringJoiner(LADDER_COLUMN);
        joiner.add(LADDER_SPACE);
        line.getPoints().stream()
                .map(ResultView::printPoint)
                .forEach(joiner::add);
        return joiner.toString();
    }

    private static String printPoint(Point point) {
        if (point.isRight()) {
            return LADDER_LINE;
        }
        return LADDER_SPACE;
    }

    private static String gameItems(ExecutionResults items) {
        return items.getResults().stream()
                .map(item -> String.format(FIVE_SIZE_FORMAT, item))
                .collect(joining(WHITE_SPACE));
    }

    private static String gameResults(List<String> playersName, Map<String, String> resultItems) {
        return playersName.stream()
                .map(name -> name + DELIMITER + resultItems.get(name))
                .collect(joining(ENTER));
    }

}