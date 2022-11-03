package ladder.domain.ladder.size;

import ladder.exception.ladder.LadderWidthBoundException;

import java.util.Objects;

public class LadderWidth {

    private static final int LADDER_WIDTH_MIN = 1;
    private final int width;

    public LadderWidth(int width) {
        validLadderWidthBound(width);
        this.width = width;
    }

    private static void validLadderWidthBound(int width) {
        if (width < LADDER_WIDTH_MIN) {
            throw new LadderWidthBoundException(LADDER_WIDTH_MIN);
        }
    }

    public int lastLadderIndex() {
        return width - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderWidth that = (LadderWidth) o;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
