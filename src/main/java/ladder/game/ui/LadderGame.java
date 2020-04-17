package ladder.game.domain;

import ladder.ladder.domain.Ladder;

public class LadderGame {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;

    private LadderGame(Ladder ladder, LadderGameInfo ladderGameInfo) {
        this.ladder = ladder;
        this.ladderGameInfo = ladderGameInfo;
    }

    public static LadderGame init(LadderGameInfo ladderGameInfo, int height) {
        Ladder ladder = Ladder.of(height, ladderGameInfo.getPlayers());
        return new LadderGame(ladder, ladderGameInfo);
    }

    static LadderGame of(Ladder ladder, LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladder, ladderGameInfo);
    }

    public LadderGameResults play() {
        return LadderGameResults.play(ladder, ladderGameInfo);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }
}
