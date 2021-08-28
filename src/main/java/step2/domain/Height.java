package step2.domain;

public class Height {
    public static final int MIN_HEIGHT = 1;
    private final int value;

    public Height(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1보다 작을 수 없습니다.");
        }
        this.value = value;
    }
}
