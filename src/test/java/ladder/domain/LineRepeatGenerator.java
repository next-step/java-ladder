package ladder.domain;

public class LineRepeatGenerator implements LineGenerator {
    private boolean value = true;

    @Override
    public boolean getRight() {
        value = !value;
        return value;
    }
}
