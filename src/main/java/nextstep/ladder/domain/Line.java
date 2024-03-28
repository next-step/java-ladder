package nextstep.ladder.domain;

import nextstep.ladder.exception.LineConsecutivePointException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final Random RANDOM = new Random();

    private final List<Boolean> points;

    public static Line of(int pointSize) {
        return new Line(random(pointSize));
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    private Line(List<Boolean> points) {
        validateConsecutivePoint(points);
        this.points = points;
    }

    private static void validateConsecutivePoint(List<Boolean> points) {
        if (hasConsecutivePoint(points)) {
            throw new LineConsecutivePointException(points);
        }
    }

    private static List<Boolean> random(int pointSize) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, pointSize - 1)
                .forEach((index) -> add(points, index));
        return Collections.unmodifiableList(points);
    }

    private static void add(List<Boolean> points, int index) {
        if (isTruePreviousPoint(points, index)) {
            points.add(false);
        }
        points.add(RANDOM.nextBoolean());
    }

    private static boolean isTruePreviousPoint(List<Boolean> points, int index) {
        return index != 0 && points.get(index - 1);
    }

    private static boolean hasConsecutivePoint(List<Boolean> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(index -> points.get(index) && points.get(index + 1));
    }

    public List<Boolean> get() {
        return this.points;
    }

}
