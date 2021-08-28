package nextstep.ladder.domain.point.strategy;

public class SequentialConnectedPointGenerateStrategy implements ConnectedPointGenerateStrategy {

    private final int inclusiveUpperBound;
    private int current = 0;

    public SequentialConnectedPointGenerateStrategy(int inclusiveUpperBound) {
        this.inclusiveUpperBound = inclusiveUpperBound;
    }

    @Override
    public int generate() {
        return this.current++;
    }

    @Override
    public boolean hasNext() {
        return this.current <= this.inclusiveUpperBound;
    }
}
