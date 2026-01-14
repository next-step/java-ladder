package nextstep.ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private static void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 %d 이상이어야 합니다.".formatted(MIN_HEIGHT));
        }
    }
}
