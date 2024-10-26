package ladder.ladder;

import java.util.Objects;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public Height(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 " + MINIMUM_HEIGHT + "이상으로 입력해주세요.");
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
