package nextstep.ladder.domain;

import nextstep.ladder.exception.WrongLadderHeightException;

public class LadderHeight {

    private final int MINIMUM_SIZE = 1;

    private final int ladderHeight;

    private LadderHeight(int ladderHeight) {
        validate(ladderHeight);
        this.ladderHeight = ladderHeight;
    }

    public static LadderHeight of(int ladderHeight) {
        return new LadderHeight(ladderHeight);
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < MINIMUM_SIZE) {
            throw new WrongLadderHeightException(
                String.format("사다리높이는 최소 %d이상이여야합니다.", ladderHeight));
        }
    }

    public int value() {
        return ladderHeight;
    }
}
