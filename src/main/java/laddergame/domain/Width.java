package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Width {
    public static final int MINUM_WIDTH = 1;
    private final int width;

    public Width(int width) {
        validateOverMinimum(width);
        this.width = width;
    }

    private void validateOverMinimum(int width) {
        if (width < MINUM_WIDTH) {
            throw new LadderGameException(ErrorCode.WIDTH_UNDER_MINIMUM);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Width width1 = (Width) o;
        return width == width1.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
