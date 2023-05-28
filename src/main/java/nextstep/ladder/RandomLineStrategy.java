package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private Random random = new Random();
    private boolean lastLine = false;

    public RandomLineStrategy() {
    }

    public RandomLineStrategy(Random random) {
        this.random = random;
    }

    @Override
    public List<Cross> generate(int countOfVerticalLine) {
        return IntStream.rangeClosed(0, countOfVerticalLine - 1)
                .mapToObj(i -> drawLine(i, countOfVerticalLine))
                .collect(Collectors.toList());
    }

    @Override
    public Cross drawLine(int index, int size) {
        boolean last = lastLine;
        boolean point = !lastLine && random.nextBoolean();
        this.lastLine = point;

        if (index == 0) {
            return new Cross(false, point);
        }
        if (index == size - 1) {
            return new Cross(last, false);
        }
        return new Cross(last, point);
    }
}
