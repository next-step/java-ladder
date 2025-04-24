package nextstep.domain;

import java.util.Objects;

public class Height {
    private final Integer height;

    private Height(Integer height) {
        validate(height);
        this.height = height;
    }

    public static Height of(Integer height) {
        return new Height(height);
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 0이나 음수가 될 수 없습니다.");
        }
    }

    public int height() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Height height1 = (Height)o;
        return Objects.equals(height, height1.height);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height);
    }
}
