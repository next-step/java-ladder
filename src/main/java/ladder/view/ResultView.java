package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_PIPE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String PLAYER_EMPTY = "   ";
    private static final String ENTER = "\n";
    public static final String GAME_RESULT = "실행결과";

    public static void printPlayers(Players players) {
        System.out.println(GAME_RESULT);
        System.out.printf(PLAYER_EMPTY);
        System.out.println(
                players.getPlayers()
                        .stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(PLAYER_EMPTY)));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder output = new StringBuilder();
        int sizeOfColumn = ladder.getSizeOfColumn();

        ladder.getRows()
                .forEach(row -> {
                    output.append(LADDER_EMPTY);
                    output.append(generateLinePrinting(row, sizeOfColumn - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.println(output.toString());
    }

    private static String generateLinePrinting(Row row, int column) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, column)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(row.hasLine(col) ? LADDER_LINE : LADDER_EMPTY);
                });
        return output.toString();
    }
}
