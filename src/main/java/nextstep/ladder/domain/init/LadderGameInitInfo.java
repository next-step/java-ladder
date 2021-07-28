package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
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
            throw new NullArgumentException(LadderInitInfo.class);
        }

        if (Objects.isNull(players)) {
            throw new NullArgumentException(Players.class);
        }
    }

    public static LadderGameInitInfo of(LadderInitInfo ladderInitInfo, Players players) {
        return new LadderGameInitInfo(ladderInitInfo, players);
    }

    public static LadderGameInitInfo of(List<String> playerNames, int ladderHeight) {
        Players players = Players.init(playerNames);
        LadderSize ladderSize = LadderSize.of(players.getNames().size(), ladderHeight);
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize);

        return new LadderGameInitInfo(ladderInitInfo, players);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public Players getPlayers() {
        return players;
    }
}
