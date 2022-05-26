package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final static Random RANDOM = new Random();
    private final static int ONE = 1;
    private final static int INITIAL = 0;

    private List<Boolean> points = new ArrayList<>();

    private Line(int countOfPerson) {
        IntStream.range(INITIAL, countOfPerson - ONE)
                .forEachOrdered(number -> points.add(RANDOM.nextBoolean()));
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
