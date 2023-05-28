package ladder.domain.ladder;

import ladder.domain.player.PlayerGroup;

public class LadderGame {

    private final Ladder ladder;
    private final PlayerGroup playerGroup;
    private final LadderResult ladderResult;

    public LadderGame(Ladder ladder, PlayerGroup playerGroup) {
        this.ladder = ladder;
        this.playerGroup = playerGroup;
        this.ladderResult = new LadderResult();
    }

    public void start() {
        for (int index = 0; index < playerGroup.size(); index++) {
            ladderResult.put(playerGroup.findPlayer(index), ladder.move(index));
        }
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
