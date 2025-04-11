package nextstep.ladder.domain.line;

import java.util.Objects;

public class Height {
    private final int value;

    public Height(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
        this.value = height;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
