package ladder.model;

public class Height {

    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1이상으로 입력해주세요");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
