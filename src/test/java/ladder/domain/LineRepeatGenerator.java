package ladder.domain;

public class LineRepeatGenerator implements LineGenerator {
    private boolean value;

    public LineRepeatGenerator(boolean lineGeneratorOrder) {
        this.value = lineGeneratorOrder;
    }

    @Override
    public boolean getRight() {
        value = !value;
        return value;
    }
}
