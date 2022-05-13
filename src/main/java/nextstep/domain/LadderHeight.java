package nextstep.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public LadderHeight(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 길이는 최소 1 이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }

}
