package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

public class LadderGame {

    private static final int LADDER_HEIGHT_MIN = 1;
    public static final String LADDER_HEIGHT_MIN_MESSAGE = "사다리의 최소 높이는 1입니다.";
    private final Participants participants;
    private final int ladderHeight;

    private LadderGame(final int ladderHeight, final String[] userName) {
        validation(ladderHeight);
        this.participants = Participants.of(userName);
        this.ladderHeight = ladderHeight;
    }

    public static LadderGame of(final int ladderHeight, final String[] userName) {
        return new LadderGame(ladderHeight, userName);
    }

    private void validation(final int ladderHeight) {
        if (ladderHeight < LADDER_HEIGHT_MIN) {
            throw new LadderException(LADDER_HEIGHT_MIN_MESSAGE);
        }
    }
}
