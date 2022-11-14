package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_POINT_NUMBER = 2;
    private static final int FIRST_POINT_NUMBER = 0;

    private final static Random RANDOM = new Random();
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(FIRST_POINT_NUMBER, countOfPerson)
                .forEachOrdered(this::insertPoint);
        validPoints(points);
    }

    public Line(List<Boolean> points) {
        validPoints(points);
        this.points.addAll(points);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    private void insertPoint(int number) {
        if (number == FIRST_POINT_NUMBER || points.get(number - 1)) {
            points.add(false);
            return;
        }
        points.add(RANDOM.nextBoolean());
    }

    private void validPoints(List<Boolean> points) {
        vaildPointsSize(points);
        validLinks(points);
    }

    private static void vaildPointsSize(List<Boolean> points) {
        if (points == null || points.size() < MIN_POINT_NUMBER) {
            throw new IllegalArgumentException(String.format("포인트는 %d개이상 있어야 합니다.", MIN_POINT_NUMBER));
        }
    }

    private void validLinks(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            boolean currentPoint = points.get(i);
            boolean nextPoint = points.get(i + 1);
            vaildLinkPoint(i, currentPoint, nextPoint);
        }
    }

    private void vaildLinkPoint(int index, boolean currentPoint, boolean nextPoint) {
        if (index == FIRST_POINT_NUMBER){
            validFirstPoint(currentPoint);
            return;
        }
        if (currentPoint && nextPoint) {
            throw new IllegalArgumentException("연속해서 연결선이 올수 없습니다.");
        }
    }
    private void validFirstPoint(boolean point) {
        if (point) {
            throw new IllegalArgumentException("첫번째 포인트는 연결선(true)일수 없습니다.");
        }
    }

    public int linkSize() {
        return (int) points.stream()
                .filter(point -> point)
                .count();
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
