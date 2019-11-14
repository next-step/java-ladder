package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int FIRST_LINE_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int size, int height) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Point> points = initPoints(i, height);
            lines.add(new Line(points));
        }
    }

    private List<Point> initPoints(int index, int height) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(createPoint(index, height));
        }

        return points;
    }

    public Point createPoint(int index, int height) {
        if (index == FIRST_LINE_INDEX) {
            return Point.firstIndex();
        }

        Point previousPoint = getPoint(index - 1, height);
        return previousPoint.next(getLastIndex());
    }

    public int getLastIndex() {
        return lines.size() - 1;
    }

    public Direction getDirection(int index, int height) {
        return lines.get(index).getDirectionByHeight(height);
    }

    public Point getPoint(int index, int height) {
        return lines.get(index).getPointByHeight(height);
    }

    public int size() {
        return lines.size();
    }
}
