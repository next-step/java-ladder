package cc.oakk.ladder.model.size;

import java.util.Objects;

public class LadderHeight {
    private final int height;

    public LadderHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 넣어주세요.");
        }
        this.height = height;
    }

    public int get() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LadderHeight)) {
            return false;
        }
        LadderHeight ladderHeight = (LadderHeight) o;
        return height == ladderHeight.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
