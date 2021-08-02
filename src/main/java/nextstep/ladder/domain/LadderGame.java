package nextstep.ladder.domain;

import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.player.Players;

import java.util.Objects;

public class LadderGame {
    private final Players players;
    private final LadderInfo ladderInfo;

    private LadderGame(LadderGameInfo ladderGameInfo) {
        validate(ladderGameInfo);

        this.players = ladderGameInfo.getPlayers();
        this.ladderInfo = ladderGameInfo.getLadderInfo();
    }

    private void validate(LadderGameInfo ladderGameInfo) {
        if (Objects.isNull(ladderGameInfo)) {
            throw new IllegalArgumentException("LadderGameInfo는 null이면 안된다");
        }
    }

    public static LadderGame of(LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladderGameInfo);
    }

}
