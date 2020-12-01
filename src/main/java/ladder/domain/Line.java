package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final static Random RANDOM = new Random();

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        return new Line(addPoints(countOfPerson));
    }

    public static Boolean isLine() {
        return RANDOM.nextBoolean();
    }

    private static List<Boolean> addPoints(int countOfPerson) {
        return IntStream.range(0, countOfPerson)
                .mapToObj(i -> isLine())
                .collect(Collectors.toList());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
