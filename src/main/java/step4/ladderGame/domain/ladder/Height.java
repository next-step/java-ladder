package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.exception.HeightLowException;

import java.util.Objects;

public final class Height {

    private static final int MIN_LENGTH_BY_HEIGHT = 1;

    private final int height;

    private Height(final int height) {
        this.height = height;
    }

    public static Height valueOf(final int height) {
        validate(height);
        return new Height(height);
    }

    private static void validate(final int height) {
        if (height < MIN_LENGTH_BY_HEIGHT) {
            throw new HeightLowException();
        }
    }

    public int getValue() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

}
