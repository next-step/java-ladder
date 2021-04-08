package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

public class LadderHeight {

    private static final int LADDER_HEIGHT_MIN = 1;
    private static final String LADDER_HEIGHT_MIN_MESSAGE = "사다리의 최소 높이는 1입니다.";
    private int ladderHeight;

    private LadderHeight(final int ladderHeight) {
        validation(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    public static LadderHeight of(final int ladderHeight) {
        return new LadderHeight(ladderHeight);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    private void validation(final int ladderHeight) {
        if (ladderHeight < LADDER_HEIGHT_MIN) {
            throw new LadderException(LADDER_HEIGHT_MIN_MESSAGE);
        }
    }
}
