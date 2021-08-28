package step2.domain;

public class Ladder {
    public static final int MIN_HEIGHT = 1;
    private final int height;

    public Ladder(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
        }
        this.height = height;
    }
}
