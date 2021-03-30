package ladder.entity.ladderMap;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

public class LadderHeight {

    private int height;

    public LadderHeight(int height) {
        this.height = verifiedHeight(height);
    }

    private int verifiedHeight(int height) {
        if (height <= 0) {
            throw new CustomException(ErrorCode.INVALID_LADDER_HEIGHT);
        }
        return height;
    }

    public int height() {
        return height;
    }
}
