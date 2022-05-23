package nextstep.ladder.doman;

import java.util.Objects;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;

    private final int value;

    public LadderHeight(int height) {
        validate(height);
        this.value = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("최소 사다리 높이는 1입니다. 입력 사다리 높이 : %d", height));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
