package ladder.strategy;

public class FixedLadderStrategy implements LadderStrategy {

    private final boolean constantValue;

    public FixedLadderStrategy(boolean constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public boolean firstLine() {
        return constantValue;
    }

    @Override
    public boolean nextLine(boolean previous) {
        return constantValue;
    }
}
