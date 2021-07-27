package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;

import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final Players players;

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, Players players) {
        validate(ladderInitInfo, players);

        this.ladderInitInfo = ladderInitInfo;
        this.players = players;
    }

    private void validate(LadderInitInfo ladderInitInfo, Players players) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new IllegalArgumentException("LadderInitInfo can't be null");
        }

        if (Objects.isNull(players)) {
            throw new IllegalArgumentException("Players can't be null");
        }
    }

    public static Object of(LadderInitInfo ladderInitInfo, Players players) {
        return new LadderGameInitInfo(ladderInitInfo, players);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public Players getPlayers() {
        return players;
    }
}
