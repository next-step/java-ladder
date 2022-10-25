package ladder.domain.ladder;

import java.util.Objects;

public class LadderWidth {

    private final int width;

    public LadderWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderWidth that = (LadderWidth) o;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
