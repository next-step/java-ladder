package ladder.domain;

import ladder.exception.NegativeHeightException;

public class Height {

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < 0) {
            throw new NegativeHeightException();
        }
    }

    public int height() {
        return this.height;
    }

}
