package ladder.domain.horizontallinecreationstrategy;

public class FixedHorizontalLineStrategy implements HorizontalLineStrategy {

    private final boolean value;

    public FixedHorizontalLineStrategy(boolean value) {
        this.value = value;
    }

    @Override
    public boolean isAbleToGenerate() {
        return value;
    }
}
