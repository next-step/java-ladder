package nextstep.ladder;

public class Height {
    private final int value;

    public Height(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
        this.value = value;
    }
}
