package nextstep.ladder.model.strategy.line;

public class FixedLineStrategyImpl implements LineStrategy{
    private final boolean value;

    public FixedLineStrategyImpl(boolean value) {
        this.value = value;
    }

    @Override
    public boolean drawLine() {
        return this.value;
    }
}
