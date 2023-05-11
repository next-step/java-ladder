package ladder;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private static final Random RANDOM = new Random();

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        if (isNotValid(points)) {
            throw new IllegalArgumentException("겹치는 가로라인이 존재합니다.");
        }
        this.points = points;
    }

    private boolean isNotValid(List<Boolean> points) {
        return IntStream.range(1, points.size())
            .anyMatch(i -> isOverlapping(points.get(i - 1), points.get(i)));
    }

    private boolean isOverlapping(Boolean a, Boolean b) {
        return isTrue(a) && isTrue(b);
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line of(int countOfPerson) {
        return new Line(randomList(countOfPerson - 1));
    }

    private static List<Boolean> randomList(int size) {
        return Stream.iterate(nextPoint(Boolean.FALSE), Line::nextPoint)
            .limit(size)
            .collect(Collectors.toList());
    }

    private static Boolean nextPoint(Boolean prev) {
        if (isTrue(prev)) {
            return Boolean.FALSE;
        }
        return randomPoint();
    }

    private static boolean isTrue(Boolean prev) {
        return prev.equals(Boolean.TRUE);
    }

    private static boolean randomPoint() {
        return RANDOM.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public List<Boolean> points() {
        return List.copyOf(points);
    }

}
