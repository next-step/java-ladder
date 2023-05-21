package ladder.domain;

import static ladder.domain.exception.LadderException.HEIGHT_UNDER_ZERO;

public class Height {

    private final int height;

    public Height(int height) {
        this.height = heightValidation(height);
    }

    public int getHeight() {
        return this.height;
    }

    public static Height from(int height) {
        return new Height(height);
    }

    private int heightValidation(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(HEIGHT_UNDER_ZERO.getMessage());
        }

        return height;
    }
}
