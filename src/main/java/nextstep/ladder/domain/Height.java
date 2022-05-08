package nextstep.ladder.domain;

public class Height {

    public static final int MINIMUM_LADDER_HEIGHT = 2;
    public static final int MAXIMUM_LADDER_HEIGHT = 100;

    private int height;

    public Height(int height) {
        if (isInvalid(height)) {
            throw new IllegalArgumentException("유효하지 않은 사다리 길이");
        }

        this.height = height;
    }

    private boolean isInvalid(int maxLadderHeight) {
        return maxLadderHeight < MINIMUM_LADDER_HEIGHT
            || maxLadderHeight > MAXIMUM_LADDER_HEIGHT;
    }

    public int get() {
        return height;
    }

}
