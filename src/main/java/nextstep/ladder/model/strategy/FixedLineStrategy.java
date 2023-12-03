package nextstep.ladder.model.strategy;

public class FixedLineStrategy implements LineStrategy{
    private final boolean value;

    public FixedLineStrategy(boolean value) {
        this.value = value;
    }

    @Override
    public boolean drawLine() {
        return this.value;
    }
}
