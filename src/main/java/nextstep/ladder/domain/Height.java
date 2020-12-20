package nextstep.ladder.domain;

public class Height {
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1은 넘어야죠");
        }
    }
}
