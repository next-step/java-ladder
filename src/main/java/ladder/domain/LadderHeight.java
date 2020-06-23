package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 2;

    private final int height;

    private LadderHeight(int height) {
        validateMinHeight(height);
        this.height = height;
    }

    public static LadderHeight of(int height) {
        return new LadderHeight(height);
    }

    public int get() {
        return height;
    }

    public void validateMinHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 2이상 이어야 합니다.");
        }
    }
}
