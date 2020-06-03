package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;

import java.util.Objects;

public class Height {

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height newInstance(int height) {
        validate(height);
        return new Height(height);
    }

    private static void validate(int height) {
        if (height < 1) {
            throw new InputValueException("사다리 높이는 0 보다 커야 합니다.");
        }
    }

    public int getHeight() {
        return this.height;
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
