package ladder.domain.generator;

public class StubBooleanGenerator implements BooleanGenerator {

    private boolean value;

    public StubBooleanGenerator(boolean value) {

        this.value = value;
    }

    @Override
    public boolean generate() {

        return value;
    }
}
