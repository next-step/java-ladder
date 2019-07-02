package ladder.domain.generator;

public class StubPointGenerator implements PointGenerator {

    private boolean b;

    public StubPointGenerator(boolean b) {

        this.b = b;
    }

    @Override
    public boolean generate() {

        return b;
    }
}
