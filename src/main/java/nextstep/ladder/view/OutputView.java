package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Order;
import nextstep.ladder.domain.Point;

import java.util.stream.IntStream;

public class OutputView {
    private static final String VERTICAL_LADDER_LINE = "|";
    private static final String LADDER_CONNECTION_LINE = "-----";
    private static final String BLANK_INTERVAL = "     ";

    private OutputView() {
    }

    public static void drawLadder(Ladder ladder) {
        IntStream.rangeClosed(1, ladder.getNumberOfUser())
                .forEach(index -> System.out.printf(String.format("%5s ", ladder.findByOrder(Order.of(index)).getLadderGameUser())));
        System.out.println();

        for (int currentPosition = 0; currentPosition < ladder.getMaxHeight(); currentPosition++) {
            System.out.println(BLANK_INTERVAL + drawLadderLine(ladder, currentPosition));
        }

    }

    private static String drawLadderLine(final Ladder ladder, final int currentPosition) {
        StringBuilder ladderLine = new StringBuilder();
        for (int currentUser = 1, count = ladder.getNumberOfUser(); currentUser <= count; currentUser++) {
            ladderLine.append(VERTICAL_LADDER_LINE);
            ladderLine.append(drawConnectionLine(ladder, currentPosition, currentUser));
        }
        return ladderLine.toString();
    }

    private static String drawConnectionLine(final Ladder ladder, final int currentPosition, final int currentUser) {
        StringBuilder connectionLine = new StringBuilder();
        if (isConnected(ladder, currentPosition, currentUser)) {
            connectionLine.append(LADDER_CONNECTION_LINE);
        } else {
            connectionLine.append(BLANK_INTERVAL);
        }
        return connectionLine.toString();
    }

    private static boolean isConnected(final Ladder ladder, final int currentPosition, final int currentUser) {
        return ladder.findByOrder(Order.of(currentUser)).connectedWith(Point.of(currentPosition));
    }
}
