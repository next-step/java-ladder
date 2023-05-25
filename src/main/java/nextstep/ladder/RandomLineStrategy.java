package nextstep.ladder;

import java.util.ArrayList;
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
    public List<Boolean> generate(int countOfVerticalLine) {
        return IntStream.rangeClosed(1, countOfVerticalLine-1)
                .mapToObj(i -> drawLine())
                .collect(Collectors.toList());
    }

    @Override
    public boolean drawLine() {
        boolean point = !lastLine && random.nextBoolean();
        this.lastLine = point;
        return point;
    }
}
