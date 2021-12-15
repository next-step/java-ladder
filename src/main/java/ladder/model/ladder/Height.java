package ladder.model.ladder;

import java.util.Objects;

public class Height {

    private static final int MIN_HEIGHT = 0;
    private final int height;

    public Height(int height) {
        checkValidation(height);
        this.height = height;
    }

    private void checkValidation(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 " + MIN_HEIGHT + " 이상이여야 합니다.");
        }
    }

    public int get() {
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
