package ladder.domain;

import java.util.Random;

public class LineStrategyRandom implements LineStrategy {

    private final int columnLimit;
    private final int rowLimit;

    private final Random random;

    public LineStrategyRandom(int columnLimit, int rowLimit) {
        this.columnLimit = columnLimit-1;
        this.rowLimit = rowLimit;
        this.random = new Random();
    }

    public static LineStrategy ofLimit(int columnLimit, int rowLimit) {
        return new LineStrategyRandom(columnLimit, rowLimit);
    }

    @Override
    public int anyRow() {
        return random.nextInt(rowLimit);
    }

    @Override
    public int anyColumn() {
        return random.nextInt(columnLimit);
    }
}
