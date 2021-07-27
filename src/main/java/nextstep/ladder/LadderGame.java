package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderResult;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    private LadderGame(LadderGameInitInfo ladderGameInitInfo) {
        this.players = ladderGameInitInfo.getPlayers();
        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
    }

    public static LadderGame init(LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public LadderResult matchResult() {
        return LadderResult.of(players.getNames(), ladder.getSteps());
    }
}
