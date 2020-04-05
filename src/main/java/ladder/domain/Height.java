package ladder.domain;

public class Height {
    private static final int HEIGHT_MIN = 1;

    private final int height;

    public static final Height of(int input) {
        return new Height(input);
    }

    private Height(int height) {
        verifyRange(height);
        this.height = height;
    }

    private void verifyRange(int height) {
        if (height < HEIGHT_MIN) {
            throw new IllegalArgumentException(String.format("높이는 0보다 큰 정수여야 합니다.(%d)", height));
        }
    }

    public int getHeight() {
        return height;
    }
}
