package ladder.domain.ladder;

import ladder.constants.Constants;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

public class Height {
    private int height;

    public Height(int height) {
        if (!validHeight(height)) {
            throw new CustomException(ErrorCode.INVALID_LADDER_HEIGHT);
        }
        this.height = height;
    }

    private boolean validHeight(int height) {
        return height > Constants.ZERO;
    }

    public int height() {
        return this.height;
    }
}
