package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();
    private static final int ODD_EVEN = 2;

    private final List<Point> points;
    private final int countOfPerson;

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.points = new ArrayList<>();
    }

    public static Line ofAutoLine(int countOfPlayer) {
        Line line = new Line(countOfPlayer);
        
        line.addPoint(Point.of(generateWidthLine()));
        IntStream.range(1, countOfPlayer-1).forEach(i -> {
            boolean point = !line.getLastPoint().hasaWidthLine() && generateWidthLine();
            line.addPoint(Point.of(point));
        });
        line.addPoint(Point.of(false));

        return line;
    }

    public void addPoint(Point nextPoint) {
        validateLineSize();
        validateOperlapLine(nextPoint);
        this.points.add(nextPoint);
    }

    private void validateOperlapLine(Point nextPoint) {
        if (!points.isEmpty() && isOverlap(nextPoint)) {
            throw new IllegalArgumentException("가로 라인이 겹칩니다.");
        }
    }

    private void validateLineSize() {
        if (this.points.size() == this.countOfPerson) {
            throw new IllegalStateException();
        }
    }
    
    private boolean isOverlap(Point nextPoint) {
        return nextPoint.hasaWidthLine() && getLastPoint().equals(nextPoint);
    }

    private Point getLastPoint() {
        return this.points.get(this.points.size()-1);
    }

    private static boolean generateWidthLine() {
        return (random.nextInt(ODD_EVEN) + 1) % 2 == 0;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}