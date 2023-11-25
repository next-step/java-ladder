package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineFactory {

    private LineFactory() {
    }

    private static Random random = new Random();

    public static Line createLine(int countOfPerson) {
        List<Boolean> points = randomPoints(countOfPerson);
        validatePoints(points);
        return new Line(points);
    }

    private static List<Boolean> randomPoints(int countOfPerson) {
        return IntStream.range(0, countOfPerson - 1)
                .mapToObj(i -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    private static void validatePoints(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .forEach(index -> adjustPoints(points, index));
    }

    private static void adjustPoints(List<Boolean> points, int index) {
        Boolean prev = points.get(index);
        Boolean next = points.get(index + 1);
        if (prev && next) {
            points.set(index + 1, false);
        }
    }

}
