package ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private static final int MINIMAL_HEIGHT = 1;
    private static final String MIN_HEIGHT_MESSAGE = "사다리 높이는 1이상 숫자를 입력해야 합니다.";

    private final int height;

    public LadderHeight(String height) {
        this(toInt(height));
    }

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    private static int toInt(String height) {
        try {
            return Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(MIN_HEIGHT_MESSAGE);
        }
    }

    private static void validate(int height) {
        if (height < MINIMAL_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT_MESSAGE);
        }
    }

    int height() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
