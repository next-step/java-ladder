package ladder;

import java.util.Objects;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 5;

    private int height;

    private LadderHeight() {}

    public static LadderHeight of(int height) {
        validate(height);
        LadderHeight ladderHeight = new LadderHeight();
        ladderHeight.height = height;
        return ladderHeight;
    }

    private static void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 %d~%d여야 합니다. : %s", MIN_HEIGHT, MAX_HEIGHT, height));
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
