package nextstep.ladder.domain;

import java.util.Comparator;
import java.util.Objects;

import nextstep.ladder.exception.InvalidHeightException;

public class Height implements Comparator<Height> {
    private static final int MIN_HEIGHT_LENGTH = 1;
    private int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(final int height) {
        if (height < MIN_HEIGHT_LENGTH) {
            throw new InvalidHeightException("사다리 높이는 최대 " + MIN_HEIGHT_LENGTH + "이상 이어야 합니다.");
        }
    }

    public static Height copyOf(final Height source) {
        return new Height(source.height);
    }

    public void decrease() {
        this.height -= 1;
    }

    public boolean isZero() {
        return height == 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public int compare(final Height o1, final Height o2) {
        return Integer.compare(o1.height, o2.height);
    }
}
