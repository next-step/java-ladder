package ladder.domain;

public class LineFixGenerator implements LineGenerator{
    private final boolean value;

    public LineFixGenerator(boolean value) {
        this.value = value;
    }

    @Override
    public boolean getRight() {
        return value;
    }
}
