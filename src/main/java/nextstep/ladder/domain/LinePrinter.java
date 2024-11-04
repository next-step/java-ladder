package nextstep.ladder.domain;

import java.util.List;

public class LinePrinter {

    private static final String BAR = "|";
    private static final String NEWLINE = "\n";
    private static final String EMPTY_SPACE = "     ";
    private static final String CONNECTED_STRING = "|-----";
    private static final String DISCONNECTED_STRING = "|     ";

    public static String convertLineToString(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder builder = new StringBuilder();
        builder.append(EMPTY_SPACE);
        for (int position = 0; position < points.size() - 1; position++) {
            Point point = points.get(position);
            builder.append(getCurrentPositionStatus(point));
        }
        builder.append(BAR);
        builder.append(NEWLINE);
        return builder.toString();
    }

    private static String getCurrentPositionStatus(Point point) {
        return point.isRightDirection() ? CONNECTED_STRING : DISCONNECTED_STRING;
    }
}
