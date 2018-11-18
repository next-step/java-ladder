package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points;

    private Line(List<Point> points) {
        if (isOverlap(points)) {
            throw new IllegalArgumentException("가로 라인이 겹칩니다.");
        }
        this.points = points;
    }

    private boolean isOverlap(List<Point> points) {
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i-1).hasaWidthLine()
                    && points.get(i-1).equals(points.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static Line of(int countOfPlayer) {
        List<Point> points = new ArrayList<>();

        points.add(Point.of(generateWidthLine()));
        IntStream.range(1, countOfPlayer-1).forEach(i -> {
            boolean point = !points.get(i - 1).hasaWidthLine() && generateWidthLine();
            points.add(Point.of(point));
        });
        points.add(Point.of(false));

        return new Line(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    private static boolean generateWidthLine() {
        return (random.nextInt(2) + 1) % 2 == 0;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}