package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;

public class OutputView {
    private static final String VERTICAL_LADDER_LINE = "|";
    private static final String LADDER_CONNECTION_LINE = "-----";
    private static final String NAME_INTERVAL = "     ";

    private OutputView() {
    }

    public static void drawLadder(Ladder ladder) {
        for (String userName : ladder.getGameUserName()) {
            System.out.printf(String.format("%5s ", userName));
        }
        System.out.println();

        for (int currentPosition = 0; currentPosition < ladder.getMaxHeight(); currentPosition++) {
            StringBuilder outputResult = new StringBuilder(NAME_INTERVAL);
            drawLadderLine(ladder, currentPosition, outputResult);
            System.out.println(outputResult.toString());
        }

    }

    private static void drawLadderLine(final Ladder ladder, final int currentPosition, final StringBuilder outputResult) {
        for (int i = 0, count = ladder.getNumberOfBaseLine(); i < count; i++) {
            outputResult.append(VERTICAL_LADDER_LINE);
            drawConnectionLine(ladder, currentPosition, outputResult, i);
        }
    }

    private static void drawConnectionLine(final Ladder ladder, final int currentPosition, final StringBuilder outputResult, final int i) {
        if (isConnected(ladder, currentPosition, i)) {
            outputResult.append(LADDER_CONNECTION_LINE);
        } else {
            outputResult.append(NAME_INTERVAL);
        }
    }

    private static boolean isConnected(final Ladder ladder, final int currentPosition, final int i) {
        return ladder.getConnectionPoints(i).has(Point.of(currentPosition));
    }
}
