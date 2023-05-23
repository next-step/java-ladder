package nextstep.ladder.domain;

import java.security.InvalidParameterException;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;

    private int height;

    public LadderHeight(int height) {
        if (isInvalidHeight(height)) {
            throw new InvalidParameterException("입력한 사다리 높이를 확인하세요. 높이: " + height);
        }
        this.height = height;
    }

    private boolean isInvalidHeight(int height) {
        return height < MIN_LADDER_HEIGHT;
    }

    public int getHeight() {
        return height;
    }
}
