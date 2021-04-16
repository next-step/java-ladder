package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

import java.util.Objects;

import static nextstep.ladder.exception.LadderExceptionMessage.CHECK_LADDER_HEIGHT;

public class LadderHeight {
    private static final int HEIGHT_MIN = 1;

    private final int height;

    public LadderHeight(String height) {
        this(Integer.valueOf(height));
    }

    public LadderHeight(int height) {
        validateLength(height);
        this.height = height;
    }

    private void validateLength(int height) {
        if (height < HEIGHT_MIN) {
            throw new LadderException(CHECK_LADDER_HEIGHT);
        }
    }

    public int value() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight ladderHeight = (LadderHeight) o;
        return this.height == ladderHeight.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
