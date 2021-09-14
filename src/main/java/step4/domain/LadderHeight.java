package step4.domain;

import step4.exceptions.MinimumHeightValueException;

public class LadderHeight {
    private static final int MIN = 1;
    private final int value;

    public LadderHeight(int value) {
        validHeight(value);
        this.value = value;
    }

    private void validHeight(int value) {
        if (value < MIN) {
            throw new MinimumHeightValueException();
        }
    }

    public int value() {
        return value;
    }
}
