package nextstep.ladder.domain;

import java.util.List;

public class LadderPrinter {

    private static final String EMPTY_SPACE = "     ";
    private static final String CONNECTED_STRING = "|-----";
    private static final String DISCONNECTED_STRING = "|     ";

    private final Ladder ladder;

    public LadderPrinter(Ladder ladder) {
        this.ladder = ladder;
    }

    public String printLadder() {
        StringBuilder result = new StringBuilder();
        for (Line line : ladder.getLines()) {
            result.append(convertLineToString(line));
        }
        return result.toString();
    }

    private String convertLineToString(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder builder = new StringBuilder();
        builder.append(EMPTY_SPACE);
        for (int position = 0; position < points.size() - 1; position++) {
            Point point = points.get(position);
            builder.append(getCurrentPositionStatus(point));
        }
        builder.append("|\n");
        return builder.toString();
    }

    private String getCurrentPositionStatus(Point point) {
        return point.isRightConnected() ? CONNECTED_STRING : DISCONNECTED_STRING;
    }
}
