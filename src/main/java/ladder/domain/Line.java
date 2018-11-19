package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();

    private final List<Point> points;
    private final int countOfPerson;

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
        this.points = new ArrayList<>();
    }

    public static Line ofAutoLine(int countOfPlayer) {
        Line line = new Line(countOfPlayer);
        
        line.addPoint(Point.of(false, generateWidthLine()));
        IntStream.range(1, countOfPlayer-1).forEach(i -> {
            boolean point = !line.getLastPoint().canMoveRight() && generateWidthLine();
            line.addPoint(Point.of(line.getLastPoint().canMoveRight(), point));
        });
        line.addPoint(Point.of(line.getLastPoint().canMoveRight(), false));

        return line;
    }

    public void addPoint(Point nextPoint) {
        validateLineSize();
        validateOverlapLine(nextPoint);
        this.points.add(nextPoint);
    }

    private void validateOverlapLine(Point nextPoint) {
        if (!points.isEmpty() && nextPoint.isOverlap(getLastPoint())) {
            throw new IllegalArgumentException("가로 라인이 겹칩니다.");
        }
    }

    private void validateLineSize() {
        if (this.points.size() == this.countOfPerson) {
            throw new IllegalStateException();
        }
    }
    
    private Point getLastPoint() {
        return this.points.get(this.points.size()-1);
    }

    private static boolean generateWidthLine() {
        return random.nextBoolean();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int index) {
        return points.get(index).move();
    }
}