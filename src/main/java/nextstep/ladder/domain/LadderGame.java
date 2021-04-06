package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;
    private final int ladderMaxHeight;

    private LadderGame(final int ladderMaxHeight, final String[] userName) {
        this.participants = Participants.of(userName);
        this.ladderMaxHeight = ladderMaxHeight;
    }

    public static LadderGame of(final int ladderMaxHeight, final String[] userName) {
        return new LadderGame(ladderMaxHeight, userName);
    }
}
