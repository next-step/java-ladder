package nextstep.ladder.domain;

import java.util.Objects;

public class LadderHeight {

    private final int heightOfValue;

    private LadderHeight(int heightOfValue) {
        this.heightOfValue = heightOfValue;
    }

    public static LadderHeight of(int heightOfValue) {
        if (heightOfValue < 0) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이여합니다.");
        }

        return new LadderHeight(heightOfValue);
    }

    public int height() {
        return heightOfValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderHeight that = (LadderHeight) o;
        return heightOfValue == that.heightOfValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heightOfValue);
    }
}
