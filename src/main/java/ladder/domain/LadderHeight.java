package ladder.domain;

public class LadderHeight {
    private final int height;

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    private static void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
