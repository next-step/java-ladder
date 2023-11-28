package nextstep.ladder.model;

public class Height {
    public static final int MIN_LADDER_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        checkHeightValidity(height);
        this.height = height;
    }

    private void checkHeightValidity(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 최소 높이는 " + MIN_LADDER_HEIGHT + "입니다.");
        }
    }
    public int height(){
        return this.height;
    }
}
