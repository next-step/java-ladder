package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

import java.util.stream.IntStream;

public class OutputView {
    private static final String VERTICAL_LADDER_LINE = "|";
    private static final String LADDER_CONNECTION_LINE = "-----";
    private static final String BLANK_INTERVAL = "     ";

    private OutputView() {
    }

    public static void drawLadder(Ladder ladder) {
        IntStream.rangeClosed(1, ladder.getNumberOfUsers())
                .forEach(order -> System.out.printf(String.format("%5s ", ladder.findUserNameByOrder(order))));
        System.out.println();

        for (int point = 1; point <= ladder.getMaxHeight(); point++) {
            System.out.println(BLANK_INTERVAL + drawLadderLine(ladder, point));
        }

    }

    private static String drawLadderLine(final Ladder ladder, final int point) {
        StringBuilder ladderLine = new StringBuilder();
        for (int order = 1, count = ladder.getNumberOfUsers(); order < count; order++) {
            ladderLine.append(VERTICAL_LADDER_LINE);
            ladderLine.append(drawConnectionLine(ladder, point, order));
        }
        ladderLine.append(VERTICAL_LADDER_LINE);
        return ladderLine.toString();
    }

    private static String drawConnectionLine(final Ladder ladder, final int point, final int order) {
        StringBuilder connectionLine = new StringBuilder();
        if (isConnected(ladder, point, order)) {
            connectionLine.append(LADDER_CONNECTION_LINE);
        } else {
            connectionLine.append(BLANK_INTERVAL);
        }
        return connectionLine.toString();
    }

    private static boolean isConnected(final Ladder ladder, final int point, final int order) {
        return ladder.connected(order, point);
    }
}
