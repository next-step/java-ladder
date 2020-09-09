package ladder.domain;

public class Height {
    private final int height;
    public final static int MIN_HEIGHT = 1;

    public Height(int height) {
        minHeightValidation(height);
        this.height = height;
    }

    private void minHeightValidation(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리는 1개가 최소입니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
