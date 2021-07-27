package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final Players players;

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, Players players) {
        this.ladderInitInfo = ladderInitInfo;
        this.players = players;
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
