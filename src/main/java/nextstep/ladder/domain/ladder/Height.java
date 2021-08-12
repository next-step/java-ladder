package nextstep.ladder.domain.ladder;

public class Height {
    private static final int MINIMUM_VALID_HEIGHT = 1;

    private int height;

    public Height(int heightInteger) {
        validate(heightInteger);
        height = heightInteger;
    }

    private void validate(int heightInteger) {
        if(heightInteger < MINIMUM_VALID_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MINIMUM_VALID_HEIGHT + "이상이어야 합니다.");
        }
    }

    public int getValue() {
        return height;
    }
}
