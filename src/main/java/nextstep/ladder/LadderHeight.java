package nextstep.ladder;

import java.util.Objects;

public class LadderHeight {

    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight of(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
        return new LadderHeight(height);
    }

    public int get() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height);
    }
}
