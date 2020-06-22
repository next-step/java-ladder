package ladder.view;

import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.player.Players;

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
        line.getLengths().stream()
                .map(ResultView::convertLineFormat)
                .forEach(System.out::print);

        printNewLine();
    }

    private static String convertLineFormat(int length) {
        return String.format(LINE_FORMAT, String.join(EMPTY_DELIMITER, Collections.nCopies(length, LINE_POINT)));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
