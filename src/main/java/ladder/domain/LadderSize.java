package ladder.domain;

public class LadderSize {
    protected static final String LADDER_HEIGHT_IS_WRONG = "Ladder height is wrong.";
    private static final int MIN_SIZE = 0;
    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        valid(width, height);
        this.width = width;
        this.height = height;
    }

    private void valid(int width, int height) {
        if (width <= MIN_SIZE || height <= MIN_SIZE) {
            throw new IllegalArgumentException(LADDER_HEIGHT_IS_WRONG);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
