package ladder.model.row;

import static ladder.Messages.WARNING_NOT_ALLOWED_HEIGHT_LENGTH;

public class Height {
    private static int ZERO = 0;

    private int height;

    public Height(int height) {
        validatePositive(height);
        this.height = height;
    }

    private void validatePositive(int input) {
        if (input <= ZERO) {
            throw new IllegalArgumentException(WARNING_NOT_ALLOWED_HEIGHT_LENGTH);
        }
    }

    public int getHeight() {
        return height;
    }
}
