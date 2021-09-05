package nextstep.ladder.domain;

public class Height {
    private static final int LADDER_MIN_COUNT = 1;
    private int height;

    public Height(int height) {
        if (height < LADDER_MIN_COUNT) {
            throw new IllegalArgumentException("사다리 높이는 최소 " + LADDER_MIN_COUNT + "가 되어야 합니다.");
        }
        this.height = height;
    }

    public int value() {
        return height;
    }
}
