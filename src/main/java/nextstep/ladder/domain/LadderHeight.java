package nextstep.ladder.domain;

import java.security.InvalidParameterException;

public class LadderHeight {

    private static final int MIN_LADDER_HEIGHT = 1;

    private int height;

    public LadderHeight(int height) {
        validLadderHeight(height);
        this.height = height;
    }

    private void validLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new InvalidParameterException("입력한 사다리 높이를 확인하세요. 높이: " + height);
        }
    }

    public int getHeight() {
        return height;
    }
}
