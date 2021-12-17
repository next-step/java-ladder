package ladder.domain.ladder;

import java.util.Objects;

public class LadderWidth {

    public static final int MINIMUM_WIDTH_VALUE = 1;
    public static final String ERROR_WIDTH_VALUE_MSG = "높이는 1이상 입력해주세요";

    private final int width;

    public LadderWidth(int width) {
        if (width < MINIMUM_WIDTH_VALUE) {
            throw new IllegalArgumentException(ERROR_WIDTH_VALUE_MSG);
        }
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderWidth that = (LadderWidth) o;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public String toString() {
        return "LadderWidth{" +
                "width=" + width +
                '}';
    }

}
