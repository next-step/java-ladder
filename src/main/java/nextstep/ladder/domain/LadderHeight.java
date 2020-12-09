package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class LadderHeight {

    private final int height;

    public LadderHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_HEIGHT);
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
