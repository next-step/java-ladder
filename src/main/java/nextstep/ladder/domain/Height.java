package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.Objects;

public class Height {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final int height;

    public static Height of(int height) {
        return new Height(height);
    }

    private Height(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new LadderException(LadderExceptionCode.INVAILD_LADDER_HEIGHT, String.valueOf(height));
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return getHeight() == height1.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight());
    }
}
