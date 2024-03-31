package nextstep.ladder.domain;

public class LadderHeight {
    private final int height;
    private final int MIN_HEIGHT = 1;


    public LadderHeight(int height) {
        assertValidHeight(height);
        this.height = height;
    }

    private void assertValidHeight(int height) {
        String message = String.format("[사다리] 높이는 %d 이상만 가능합니다.", MIN_HEIGHT);
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(message);
        }
    }

    public int getHeight() {
        return height;
    }
}
