package ladder.domain;

public class Height {
    private static final int MIN = 2;

    private final int height;

    public Height(int height) {
        if (height < MIN) {
            throw new IllegalArgumentException("높이는 2 이상부터 가능합니다.");
        }
        this.height = height;
    }

    public int get() {
        return height;
    }
}
