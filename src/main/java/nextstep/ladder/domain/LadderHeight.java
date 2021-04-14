package nextstep.ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private static final int HEIGHT_MIN = 1;
    private static final String CHECK_HEIGHT = "사다리 높이가 1미만인지 확인해주세요.";

    private final int height;

    public LadderHeight(String height) {
        this(Integer.valueOf(height));
    }

    public LadderHeight(int height) {
        validateLength(height);
        this.height = height;
    }

    private void validateLength(int height) {
        if (height < HEIGHT_MIN) {
            throw new IllegalArgumentException(CHECK_HEIGHT);
        }
    }

    public int value() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight ladderHeight = (LadderHeight) o;
        return this.height == ladderHeight.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
