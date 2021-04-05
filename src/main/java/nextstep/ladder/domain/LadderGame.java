package nextstep.ladder.domain;

public class LadderGame {

    private final int ladderMaxHeight;

    private LadderGame(final int ladderMaxHeight) {
        this.ladderMaxHeight = ladderMaxHeight;
    }

    public static LadderGame of(final int ladderMaxHeight, final String[] userName) {
        return new LadderGame(ladderMaxHeight);
    }
}
