package nextstep.domain.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        checkValidHeight(height);
        this.height = height;
    }

    private void checkValidHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최소한의 높이는 1 이상이여야 한다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
