package ladder.domain;

public class Height {

    public static final String HEIGHT_UNDER_ZERO = "높이는 0보다 큰 수를 입력해야 합니다.";

    private final int height;

    public static Height from(int height) {
        return new Height(height);
    }

    private Height(int height) {
        this.height = validateHeight(height);
    }

    public int getHeight() {
        return this.height;
    }

    private int validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(HEIGHT_UNDER_ZERO);
        }

        return height;
    }
}
