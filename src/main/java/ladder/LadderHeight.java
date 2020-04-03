package ladder;

public class LadderHeight {
    private int height;

    public LadderHeight(final int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Ladder height must be greater than zero.");
        }
        this.height = height;
    }

    public int toInt() {
        return height;
    }
}
