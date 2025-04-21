package ladder.domain;

public class LadderSize {
    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
