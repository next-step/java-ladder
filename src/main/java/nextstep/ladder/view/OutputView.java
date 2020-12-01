package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.io.PrintStream;
import java.util.stream.Collectors;

public class OutputView {

    private static final PrintStream out = System.out;
    public static final String BLANK = " ";
    public static final String LADDER_DELIMITER = "|";
    public static final String LADDER_PREFIX = "    " + LADDER_DELIMITER;
    public static final String CONNECTION = "-----";
    public static final String NO_CONNECTION = "     ";
    public static final String NEW_LINE = "\n";

    public static void showPlayers(Players players) {
        out.println(players.getPlayers().stream()
                .map(Player::getName)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(BLANK)));
    }

    public static void showLines(Lines lines) {
        out.println(lines.getLines().stream()
                .map(OutputView::convertLineToString)
                .collect(Collectors.joining(NEW_LINE)));
    }

    public static String convertLineToString(Line line) {
        return LADDER_PREFIX + line.getConnections().getConnections()
                .stream()
                .map(OutputView::convertConnectionToString)
                .collect(Collectors.joining(LADDER_DELIMITER)) + LADDER_DELIMITER;
    }

    private static String convertConnectionToString(Connection connection) {
        if (connection.isConnected()) {
            return CONNECTION;
        }
        return NO_CONNECTION;
    }

    public static void showLineResult(LineResult lineResult) {
        out.println(lineResult.getResults().stream()
                .map(result -> String.format("%-5s", result.getResult()))
                .collect(Collectors.joining()));
    }
}
