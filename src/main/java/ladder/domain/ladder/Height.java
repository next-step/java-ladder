package ladder.domain.ladder;

import java.util.Objects;

public class Height {

    private static final int MAXIMUM_HEIGHT = 10;
    private static final int MINIMUM_HEIGHT = 2;

    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height > MAXIMUM_HEIGHT || height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MINIMUM_HEIGHT + "이상 " + MAXIMUM_HEIGHT + "이하로 설정 해주세요.");
        }
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
