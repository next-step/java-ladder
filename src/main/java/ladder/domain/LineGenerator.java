package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LineGenerator {


    private final Random random;

    public LineGenerator() {
        this(new Random());
    }

    public LineGenerator(Random random) {
        this.random = random;
    }

    public Line generate(int numberOfPeople) {
        List<Point> points = new ArrayList<>();
        int totalIndexSize = 2 * numberOfPeople - 1;
        IntStream.range(0, totalIndexSize)
            .forEach(n -> {
                if (isPipeIndex(n)) {
                    points.add(new Point(null));
                    return;
                }
                boolean value = random.nextBoolean();
                if (lastValueIsTrue(points)) {
                    value = false;
                }
                points.add(new Point(value));
            });
        return new Line(points);
    }

    private static boolean isPipeIndex(int n) {
        return n % 2 == 0;
    }

    private boolean lastValueIsTrue(List<Point> points) {
        int oldLineIndex = points.size() - 2;
        if (oldLineIndex < 0) {
            oldLineIndex = 0;
        }
        return points.get(oldLineIndex).isTrue();
    }
}
