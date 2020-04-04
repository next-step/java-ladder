package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Node;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT = "실행결과";
    private static final String PRINT_FORMAT = "%-6s";
    private static final String PRINT_HEIGHT = "I";
    private static final String PRINT_WIDTH = "-----";

    public static void printPlayers(Players players) {
        System.out.println(LADDER_RESULT);

        String nameOutput = players.getPlayers().stream()
                .map(player -> String.format(PRINT_FORMAT, player.getName()))
                .collect(Collectors.joining());
        System.out.println(nameOutput);
    }

    public static void pringLadder(Lines lines) {
        StringBuffer buffer = new StringBuffer();

        for (Line line : lines.getLines()) {
            for (Node node : line.getNodes()) {
                if (node.isMovableRight()) {
                    buffer.append(String.format(PRINT_HEIGHT));
                    buffer.append(String.format(PRINT_WIDTH));
                } else {
                    buffer.append(String.format(PRINT_FORMAT, PRINT_HEIGHT));
                }
            }
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }
    }
}
