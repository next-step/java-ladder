package ladder.domain.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineGenerator implements LineGenerator {

    private static final Random random = new Random();

    @Override
    public Line generateLine(int width) {

        List<Boolean> points = initiallizeLine(width);
        points = applyTheRule(points);

        return new Line(points);
    }

    private List<Boolean> applyTheRule(List<Boolean> points) {
        for (int i = 1; i < points.size() - 1; i++) {
            if (points.get(i) == true) {
                previousApply(points, i - 1);
                nextApply(points, i + 1);
            }
        }
        return points;
    }

    private void previousApply(List<Boolean> points, int previousIndex) {
        if (points.get(previousIndex) == true) {
            points.remove(previousIndex);
            points.add(previousIndex, false);
        }
    }

    private void nextApply(List<Boolean> points, int nextIndex) {
        if (points.get(nextIndex) == true) {
            points.remove(nextIndex);
            points.add(nextIndex, false);
        }
    }

    private List<Boolean> initiallizeLine(int width) {
        return IntStream.range(0, width)
                .mapToObj(i -> random.nextBoolean())
                .collect(Collectors.toList());
    }
}
