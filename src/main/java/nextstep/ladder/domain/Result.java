package nextstep.ladder.domain;

public class Result {
    private static final int ZERO = 0;

    private final int index;

    public Result(int index) {
        checkMinusValue(index);
        this.index = index;
    }

    private void checkMinusValue(int index) {
        if (index < ZERO) {
            throw new IllegalArgumentException("마이너스 값이 될 수 없음");
        }
    }

    public Result move(int value) {
        return new Result(index + value);
    }

    public int getResult() {
        return index;
    }

    public boolean isSameIndex(int value) {
        return index == value;
    }
}
