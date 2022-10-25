package ladder.domain.ladder;

import ladder.exception.ladder.LadderWidthBoundException;

import java.util.Objects;

public class LadderWidth {

    private final int width;
    private static final int LADDER_WIDTH_MIN = 2;

    public LadderWidth(int width) {
        if (width < LADDER_WIDTH_MIN) {
            throw new LadderWidthBoundException(LADDER_WIDTH_MIN);
        }
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
