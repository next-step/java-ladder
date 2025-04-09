package nextstep.ladder.domain.line;

public class Height {

    private final int value;

    public Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
        this.value = height;
    }

    public int getValue() {
        return value;
    }
}
