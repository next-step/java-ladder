package nextstep.ladder;

import nextstep.ladder.exception.LineConsecutivePointException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

    private static final Random RANDOM = new Random();

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(generatePoints(getMaxPointSize(countOfPerson)));
    }

    public Line(List<Boolean> points) {
        validateConsecutivePoint(points);
        this.points = points;
    }

    private void validateConsecutivePoint(List<Boolean> points) {
        if (hasConsecutivePoint(points)) {
            throw new LineConsecutivePointException(points);
        }
    }

    private static List<Boolean> generatePoints(int pointSize) {
        List<Boolean> points = Stream.generate(RANDOM::nextBoolean)
                .limit(pointSize)
                .collect(Collectors.toUnmodifiableList());

        if (hasConsecutivePoint(points)) {
            return generatePoints(pointSize);
        }
        return points;
    }

    private static int getMaxPointSize(int countOfPerson) {
        return countOfPerson - 1;
    }

    private static boolean hasConsecutivePoint(List<Boolean> points) {
        return IntStream.range(0, getMaxPointSize(points.size()))
                .anyMatch(index -> points.get(index) && points.get(index + 1));
    }

    public List<Boolean> get() {
        return this.points;
    }

}
