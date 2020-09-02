package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_PIPE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String ENTER = "\n";

    public static void printPlayers(Players players) {
        System.out.println(
                players.getPlayers()
                        .stream()
                        .map(Player::getName)
                        .collect(Collectors.joining(LADDER_EMPTY)));
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder output = new StringBuilder();
        int ladderColumn = ladder.getCountOfPoints();

        ladder.getLines()
                .forEach(ladderLine -> {
                    output.append(LADDER_EMPTY);
                    output.append(generateLinePrinting(ladderLine, ladderColumn - 1));
                    output.append(LADDER_PIPE);
                    output.append(ENTER);
                });
        System.out.println(output.toString());
    }

    private static String generateLinePrinting(Line ladderLine, int ladderColumn) {
        StringBuilder output = new StringBuilder();
        IntStream
                .range(0, ladderColumn)
                .forEach(col -> {
                    output.append(LADDER_PIPE);
                    output.append(ladderLine.hasLine(col) ? LADDER_LINE : LADDER_EMPTY);
                });
        return output.toString();
    }
}
