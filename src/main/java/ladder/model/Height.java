package ladder.model;

public class Height {

    private static final int MIN_HEIGHT = 0;
    private final int height;

    public Height(int height) {
        checkValidation(height);
        this.height = height;
    }

    private void checkValidation(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 0 이상이여야 합니다.");
        }
    }
}
