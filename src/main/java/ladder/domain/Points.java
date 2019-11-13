package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private static final String ILLEGAL_NUMBER_OF_POINTS = "포인트 수가 0보다 커야합니다.";
    private static final int MIN_POINTS = 0;
    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points ofCount(int count) {
        return new Points(generatePoints(checkCount(count)));
    }

    private static int checkCount(int count) {
        if (count <= MIN_POINTS) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_OF_POINTS);
        }
        return count;
    }

    private static List<Point> generatePoints(int numberOfPoints) {
        return IntStream.range(0, numberOfPoints)
            .mapToObj(Point::ofOrder)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return points.stream()
            .map(Point::toString)
            .collect(Collectors.joining());
    }
}
