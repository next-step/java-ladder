package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class OutputView {
    private static final String CONNECTED_LADDER_ROW = "-----|";
    private static final String DISCONNECTED_LADDER_ROW = "     |";
    private static final String START_LADDER_COLUMN = "|";
    private static final String LINE_END = "\n";

    private OutputView() {
    }

    public static void printLadder(Players players, Lines lines) {
        print(getPlayers(players));
        print(getLines(lines));
    }

    private static String getLines(Lines lines) {
        return lines.getLines().stream()
                    .map(OutputView::getRow)
                    .collect(Collectors.joining(LINE_END));
    }

    private static String getRow(Line line) {
        return START_LADDER_COLUMN
                .concat(line.getLine()
                            .stream()
                            .map(bridge -> draw(bridge.isConnected()))
                            .collect(Collectors.joining()));
    }

    private static String draw(boolean connected) {
        if (connected) return CONNECTED_LADDER_ROW;
        return DISCONNECTED_LADDER_ROW;
    }

    private static String getPlayers(Players players) {
        return players
                .getPlayers()
                .stream()
                .map(player -> String.format("%-6s", player.getPlayer()))
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.joining());
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
