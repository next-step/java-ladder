package nextstep.ladder2.domain;

public class NxLadderGame {
    private final NxLadder ladder;
    private final NxPrizeMapper prizeMapper;

    public NxLadderGame(NxLadder ladder, NxPrizeMapper prizeMapper) {
        this.ladder = ladder;
        this.prizeMapper = prizeMapper;
    }
}
