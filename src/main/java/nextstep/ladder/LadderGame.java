package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    private LadderGame(LadderGameInitInfo ladderGameInitInfo) {
        validate(ladderGameInitInfo);
        this.players = ladderGameInitInfo.getPlayers();
        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
    }

    private void validate(LadderGameInitInfo ladderGameInitInfo) {
        if (Objects.isNull(ladderGameInitInfo)) {
            throw new NullArgumentException(LadderGameInitInfo.class);
        }
    }

    public static LadderGame init(LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public LadderResult result() {
        return LadderResult.of(players.getNames(), ladder.getSteps());
    }
}
