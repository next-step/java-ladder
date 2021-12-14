package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static ladder.utils.Constants.SYMBOL_BLANK;
import static ladder.utils.Constants.SYMBOL_VERTICAL_BAR;

public class Line {
    private List<Point> points = new ArrayList<>();
    private Random random = new Random();

    public Line(List<Point> points) {
        this.points = points;
    }

    public Line(int countOfUser) {
        boolean current = random.nextBoolean();
        points.add(Point.firstPoint(current));
        for (int i = 1; i < countOfUser - 1; i++) {
            Point point = new Point(current, random.nextBoolean());
            points.add(point);
            current = point.getCurrent();
        }
        points.add(Point.lastPoint(current));
    }

    public String getResultLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(SYMBOL_BLANK).append(SYMBOL_BLANK).append(SYMBOL_BLANK).append(SYMBOL_BLANK);
        points.forEach(point -> {
            sb.append(SYMBOL_VERTICAL_BAR);
            sb.append(point.getResultPoint());
        });
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
