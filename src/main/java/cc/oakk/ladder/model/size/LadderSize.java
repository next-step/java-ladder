package cc.oakk.ladder.model.size;

import java.util.Objects;

public class LadderSize {
    private final LadderWidth width;
    private final LadderHeight height;

    public LadderSize(int width, int height) {
        this.width = new LadderWidth(width);
        this.height = new LadderHeight(height);
    }

    public LadderWidth width() {
        return width;
    }

    public LadderHeight height() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LadderSize)) {
            return false;
        }
        LadderSize ladderSize = (LadderSize) o;
        return Objects.equals(width, ladderSize.width) && Objects.equals(height, ladderSize.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
