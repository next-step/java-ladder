package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

public class Height {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final int height;

    public static Height of(int height) {
        return new Height(height);
    }

    private Height(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new LadderException(LadderExceptionCode.INVAILD_LADDER_HEIGHT, String.valueOf(height));
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
