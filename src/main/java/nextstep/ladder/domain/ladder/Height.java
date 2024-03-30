package nextstep.ladder.domain.ladder;

public class Height {
    private final int value;

    public Height(int value) {
        assertPositive(value);

        this.value = value;
    }

    private void assertPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("사다리 높이는 음수가 될 수 없습니다.");
        }
    }
}
