package ladder.strategy;

import ladder.domain.ladder.Point;

import java.util.Random;

public class PointRandomStrategy implements PointStrategy {
    private final Random random;
    private Boolean beforeStep = false;
    private int countOfTotal;

    public PointRandomStrategy(int countOfTotal) {
        this(countOfTotal, new Random());
    }

    PointRandomStrategy(int countOfTotal, Random random) {
        this.countOfTotal = countOfTotal;
        this.random = random;
    }

    @Override
    public Point nextPoint() {
        Boolean nextStep = step();
        Point nextPoint = Point.of(beforeStep, nextStep);
        this.beforeStep = nextStep;

        return nextPoint;
    }

    private Boolean step() {
        if (isEnd() || beforeStep) {
            return false;
        }

        return random.nextBoolean();
    }

    private boolean isEnd() {
        return --this.countOfTotal == 0;
    }
}
