package ladder.domain;

public class LadderHeight {
    public static final int MIN_HEIGHT = 1;
    private final int height;

    public LadderHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("height must be bigger than 0");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
