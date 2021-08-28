package nextstep.ladder.domain.point.strategy;

import java.util.Random;

public class RandomConnectedPointGenerateStrategy implements ConnectedPointGenerateStrategy {

    private static final Random RANDOM = new Random();

    private final int upperBound;
    private int current = 0;

    public RandomConnectedPointGenerateStrategy(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public int generate() {
        ++this.current;
        return RANDOM.nextInt(upperBound);
    }

    @Override
    public boolean hasNext() {
        return this.current <= this.upperBound;
    }
}
