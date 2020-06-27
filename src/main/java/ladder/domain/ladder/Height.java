package ladder.domain.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Height of(int height) {
        return new Height(height);
    }

    public int getHeight() {
        return height;
    }
}
