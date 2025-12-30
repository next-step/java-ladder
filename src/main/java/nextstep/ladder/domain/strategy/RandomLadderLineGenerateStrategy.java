package nextstep.ladder.domain.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLadderLineGenerateStrategy implements GenerateLadderLineStrategy {

    private static Random random = new Random();
    private Boolean previousHasLine = false;

    @Override
    public List<Boolean> generate(int size) {
        return IntStream.range(0, size - 1)
                .mapToObj(i -> generateLine())
                .toList();
    }

    private Boolean generateLine() {
        Boolean currentValue = !previousHasLine && random.nextBoolean();
        this.previousHasLine = currentValue;
        return currentValue;
    }
}
