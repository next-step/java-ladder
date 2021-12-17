package ladder.domain.ladder;

import java.util.Objects;

public class LadderHeight {

    public static final int MINIMUM_HEIGHT_VALUE = 1;
    public static final String ERROR_HEIGHT_VALUE_MSG = "높이는 1이상 입력해주세요";

    private final int height;

    public LadderHeight(int height) {
        if (height < MINIMUM_HEIGHT_VALUE) {
            throw new IllegalArgumentException(ERROR_HEIGHT_VALUE_MSG);
        }
        this.height = height;
    }

    public int getHeight() {
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
        return this.height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return height + "";
    }

}
