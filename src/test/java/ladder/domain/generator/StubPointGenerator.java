package ladder.domain.generator;

public class StubPointGenerator implements PointGenerator {

    private boolean value;

    public StubPointGenerator(boolean value) {

        this.value = value;
    }

    @Override
    public boolean generate() {

        return value;
    }
}
