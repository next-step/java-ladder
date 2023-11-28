package ladder.domain.data;

import ladder.domain.exception.LadderException;

public class LadderHeight {

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (!isValid(value)) {
            throw new LadderException("사다리 높이는 0 이상이어야 합니다.");
        }
    }

    private boolean isValid(int value) {
        return value > 0;
    }

    public int value() {
        return value;
    }
}
