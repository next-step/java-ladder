package step2.domain;

public class FixedGenerator implements BooleanGenerator {
    private final boolean fixedValue;

    FixedGenerator(boolean fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public boolean nextBoolean() {
        return fixedValue;
    }
}
