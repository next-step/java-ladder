package ladder.domain;

import java.util.Objects;

public class Height {

    public static final String LADDER_MINIMUM_EXCEPTION = "사다리 게임은 최소 높이가 0보다는 크게 지정해야 합니다.";

    private static final int LADDER_MINUMUM_HEIGHT = 1;

    private final int height;

    private Height(int ladderHeight) {
        validateHeight(ladderHeight);
        this.height = ladderHeight;
    }

    private void validateHeight(int ladderHeight) {
        if (ladderHeight < LADDER_MINUMUM_HEIGHT){
            throw new IllegalArgumentException(LADDER_MINIMUM_EXCEPTION);
        }
    }

    public static Height of(int ladderHeight) {
        return new Height(ladderHeight);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
