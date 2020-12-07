package nextstep.ladder.entity.ladder;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value) {
        throwIfFloorsLessThanOne(value);
        this.value = value;
    }

    private void throwIfFloorsLessThanOne(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상으로 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }

}
