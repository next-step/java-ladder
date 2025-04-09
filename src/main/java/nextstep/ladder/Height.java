package nextstep.ladder;

public class Height {

    private int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
