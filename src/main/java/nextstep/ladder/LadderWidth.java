package nextstep.ladder;

public class LadderWidth {

    private static final int MIN_WIDTH = 2;

    private final int width;

    public LadderWidth(int width) {
        checkWidth(width);
        this.width = width;
    }

    private void checkWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new TooNarrowException();
        }
    }

    public int bodyWidth() {
        return width - MIN_WIDTH;
    }
}
