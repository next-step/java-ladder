package camp.nextstep.edu.rebellion.view;

import camp.nextstep.edu.rebellion.domain.Ladder;
import camp.nextstep.edu.rebellion.domain.Player;
import camp.nextstep.edu.rebellion.domain.Players;
import camp.nextstep.edu.rebellion.domain.Row;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_PIPE = "|";
    private static final String LADDER_HORIZON_LINE = "-----";
    private static final String LADDER_HORIZON_EMPTY = "     ";
    private static final String ENTER = "\n";

    public static void printPlayers(Players players) {
        System.out.println(
                players.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.joining(LADDER_HORIZON_EMPTY)));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder output = new StringBuilder();
        int cols = ladder.getSizeOfPoints();

        ladder.getRows()
                .forEach(row -> {
                    output.append(generatePrintingRow(row, cols - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.println(output.toString());
    }

    private static String generatePrintingRow(Row row, int cols) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, cols)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(row.hasHorizonLine(col) ?
                            LADDER_HORIZON_LINE :
                            LADDER_HORIZON_EMPTY);
                });
        return output.toString();
    }
}
