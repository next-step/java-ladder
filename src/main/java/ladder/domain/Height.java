package ladder.domain;

public class Height {
    private final int height;
    public final static int MIN_HEIGHT = 1;

    public Height(int height) {
        validateMinHeight(height);
        this.height = height;
    }

    private void validateMinHeight(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리는 1개가 최소입니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
