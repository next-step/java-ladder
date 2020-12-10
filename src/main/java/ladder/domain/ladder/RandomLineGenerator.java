package ladder.domain.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {

    private static final Random random = new Random();

    @Override
    public Line generateLine(int width) {

        List<Boolean> points = initializeLine(width);
        points = applyNotContinuousLines(points);

        return new Line(points);
    }

    private List<Boolean> initializeLine(int width) {
        return IntStream.range(0, width)
                .mapToObj(i -> random.nextBoolean())
                .collect(Collectors.toList());
    }

    private List<Boolean> applyNotContinuousLines(List<Boolean> points) {
        for (int i = 1; i < points.size() - 1; i++) {
            compareWithBothSidesElements(points, i);
        }
        return points;
    }

    private void compareWithBothSidesElements(List<Boolean> points, int currentIndex) {
        if (points.get(currentIndex) == true) {
            changeNotContinuousLines(points, currentIndex - 1);
            changeNotContinuousLines(points, currentIndex + 1);
        }
    }

    private void changeNotContinuousLines(List<Boolean> points, int index) {
        if (points.get(index) == true) {
            points.remove(index);
            points.add(index, false);
        }
    }
}
