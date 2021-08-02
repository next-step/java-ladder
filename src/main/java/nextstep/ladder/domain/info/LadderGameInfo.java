package nextstep.ladder.domain.info;

import nextstep.ladder.domain.player.Players;

import java.util.Objects;

public class LadderGameInfo {
    private final Players players;
    private final LadderInfo ladderInfo;

    private LadderGameInfo(Players players, LadderInfo ladderInfo) {
        validate(players, ladderInfo);

        this.ladderInfo = ladderInfo;
        this.players = players;
    }

    private void validate(Players players, LadderInfo ladderInfo) {
        if (Objects.isNull(ladderInfo)) {
            throw new IllegalArgumentException("LadderInfo는 null이면 안됩니다");
        }

        if (Objects.isNull(players)) {
            throw new IllegalArgumentException("Players는 null이면 안됩니다");
        }
    }

    public static LadderGameInfo of(Players players, LadderInfo ladderInfo) {
        return new LadderGameInfo(players, ladderInfo);
    }
}
