package step04.model;

public class LadderHeight {
    private static final int MINIMUM_LADDER_HEIGHT = 2;
    private static final String INVALID_LADDER_HEIGHT = "사다리의 최소 높이는 2입니다.";

    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT);
        }
    }

    public int getLineNum() {
        return height;
    }
}
