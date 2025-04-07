package ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validateInput(height);
        this.height = height;
    }

    private void validateInput(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 최소 높이는 1이상 입니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
