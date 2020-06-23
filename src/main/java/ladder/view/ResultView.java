package ladder.view;

import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.player.Players;
import ladder.domain.point.Point;
import ladder.domain.reward.Rewards;

import java.util.Collections;

public class ResultView {

    private static final String NAME_FORMAT = "%6s";
    private static final String LINE_FORMAT = "%5s|";

    private static final String EMPTY_DELIMITER = "";
    private static final String LINE_POINT = "-";

    public static void printPlayers(Players players) {
        players.getNames().stream()
                .map(ResultView::convertNameFormat)
                .forEach(System.out::print);

        printNewLine();
    }

    private static String convertNameFormat(String name) {
        return String.format(NAME_FORMAT, name);
    }

    public static void printLines(Lines lines) {
        lines.getLines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.getPoints().stream()
                .map(ResultView::convertLineFormat)
                .forEach(System.out::print);

        printNewLine();
    }

    private static String convertLineFormat(Point point) {
        return String.format(
                LINE_FORMAT,
                String.join(EMPTY_DELIMITER, Collections.nCopies(point.isMovable() ? 5 : 0, LINE_POINT)));
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printRewards(Rewards rewards) {
        rewards.getNames().stream()
                .map(ResultView::convertNameFormat)
                .forEach(System.out::print);

        printNewLine();
    }
}
