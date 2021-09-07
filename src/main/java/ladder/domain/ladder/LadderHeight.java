package ladder.domain.ladder;

import java.util.Objects;

public class LadderHeight {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private static final String INVALID_LADDER_HEIGHT_ERROR_MESSAGE = "사다리 높이는 0보다 큰 값만 들어와야 한다.";

    private final int height;

    public LadderHeight(int height) {
        checkLadderHeight(height);

        this.height = height;
    }

    private static void checkLadderHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    public int value() {
        return height;
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
