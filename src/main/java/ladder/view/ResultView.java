package ladder.view;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.Player;

import java.util.List;

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
    public static final int ZERO_INDEX = 0;

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadderResult(List<Player> players, List<Line> ladder, List<String> items) {
        System.out.println(LADDER_MSG);
        System.out.println();
        System.out.println(printPlayerName(players));
        System.out.println(printLadder(ladder));
        System.out.println(printItems(items));
        System.out.println();
    }

    public static void printGameResult(List<Player> players, List<String> results, List<Integer> positions) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(gameResults(players, results, positions));
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
        return line.getPoints().stream()
                .map(ResultView::printPoint)
                .collect(joining(LADDER_COLUMN));
    }

    private static String printPoint(Point point) {
        if (point.isRight()) {
            return LADDER_LINE;
        }
        return LADDER_SPACE;
    }

    private static String printItems(List<String> items) {
        return items.stream()
                .map(item -> String.format(FIVE_SIZE_FORMAT, item))
                .collect(joining(WHITE_SPACE));
    }

    private static String gameResults(List<Player> players, List<String> results, List<Integer> indices) {
        if (isOneResult(players, indices)) {
            return results.get(indices.get(ZERO_INDEX));
        }
        return indices.stream()
                .map(index -> players.get(index) + DELIMITER + results.get(index))
                .collect(joining(ENTER));
    }

    private static boolean isOneResult(List<Player> players, List<Integer> indices) {
        return indices.size() != players.size();
    }

}
