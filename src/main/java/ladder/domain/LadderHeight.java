package ladder.domain;

import java.util.Objects;

public class LadderHeight {

    private static final String TOO_LOW_MSG = "사다리의 높이는 1 이상이여야 합니다.";

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int height;

    public LadderHeight(int height) {
        if(tooShort(height)) {
            throw new IllegalArgumentException(TOO_LOW_MSG);
        }
        this.height = height;
    }

    private boolean tooShort(int height) {
        return height < MIN_LADDER_HEIGHT;
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
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
