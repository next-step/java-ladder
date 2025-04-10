package nextstep.ladder.module;

public class Height {
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public int value() {
        return height;
    }

    private void validate(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
    }
}
