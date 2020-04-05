package ladder;

import java.util.Objects;

public class LadderHeight {
    private int height;

    private LadderHeight(final int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Ladder height must be greater than zero.");
        }
        this.height = height;
    }

    public static LadderHeight newInstance(final int height) {
        return new LadderHeight(height);
    }

    public int toInt() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderHeight)) return false;
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
