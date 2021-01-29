package step2;

import step2.UI.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final String LADDER_LINE_DRAWING = "-----";
    private static final String LADDER_NO_LINE_DRAWING = "     ";
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line newLine(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(Point.validPrePoint(points));
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public String drawLine() {
        StringBuilder sb = new StringBuilder();

        for (Point point : points) {
            append(sb, point);
        }

        return sb.toString();
    }

    private void append(StringBuilder sb, Point point) {
        if (point.isPoint()) {
            sb.append(LADDER_LINE_DRAWING);
        } else {
            sb.append(LADDER_NO_LINE_DRAWING);
        }

        sb.append(OutputView.LADDER_HEIGHT_DRAWING);
    }

    public int size() {
        return points.size();
    }
}
