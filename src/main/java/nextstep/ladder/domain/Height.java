package nextstep.ladder.domain;

public class Height {
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 1보다 커야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
