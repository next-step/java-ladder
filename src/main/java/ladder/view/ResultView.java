package ladder.view;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.Player;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    public static final String RESULT_MSG = "실행결과";
    public static final String FIVE_SIZE_FORMAT = "%5s";
    public static final String SPACE = " ";
    public static final String LADDER_SPACE = "     |";
    public static final String LADDER_LINE = "-----|";
    public static final String ENTER = "\n";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printResult(List<Player> players, List<Line> ladder) {
        System.out.println(RESULT_MSG);
        System.out.println();
        System.out.println(printPlayerName(players));
        System.out.println(printLadder(ladder));
    }

    private static String printPlayerName(List<Player> players) {
        return players.stream()
                .map(s -> String.format(FIVE_SIZE_FORMAT, s.getPlayerName()))
                .collect(joining(SPACE));
    }

    public static String printLadder(List<Line> ladder) {
        return ladder.stream()
                .map(ResultView::printLine)
                .collect(joining(ENTER));
    }

    private static String printLine(Line line) {
        return line.getPoints().stream()
                .map(ResultView::printPoint)
                .collect(joining());
    }

    private static String printPoint(Point point) {
        if (point.isRight()) {
            return LADDER_LINE;
        }
        return LADDER_SPACE;
    }

}
