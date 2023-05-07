package ladder.domain;

import java.util.Random;

public class LineStrategyRandom implements LineStrategy {

    private final int heightLimit;
    private final int widthLimit;

    private final Random random;

    public LineStrategyRandom(int heightLimit, int widthLimit) {
        this.heightLimit = heightLimit;
        this.widthLimit = widthLimit - 1;
        this.random = new Random();
    }

    public static LineStrategy of(int heightLimit, int widthLimit) {
        return new LineStrategyRandom(heightLimit, widthLimit);
    }

    @Override
    public int horizontalPosition() {
        return random.nextInt(widthLimit);
    }

    @Override
    public int verticalPosition() {
        return random.nextInt(heightLimit);
    }
}
