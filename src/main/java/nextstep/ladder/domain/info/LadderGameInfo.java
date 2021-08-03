package nextstep.ladder.domain.info;

import nextstep.ladder.domain.player.Players;

import java.util.List;
import java.util.Objects;

import static nextstep.ladder.domain.strategy.LineCreateStrategyFactory.getRandomLineCreateStrategy;

public class LadderGameInfo {
    private final Players players;
    private final LadderInfo ladderInfo;

    private LadderGameInfo(List<String> players, LadderInfo ladderInfo) {
        validate(players, ladderInfo);

        this.players = Players.of(players);
        this.ladderInfo = ladderInfo;
    }

    private void validate(List<String> players, LadderInfo ladderInfo) {
        if (Objects.isNull(players)) {
            throw new IllegalArgumentException("Players는 null이면 안됩니다");
        }

        if (Objects.isNull(ladderInfo)) {
            throw new IllegalArgumentException("LadderInfo는 null이면 안됩니다");
        }
    }

    public static LadderGameInfo of(List<String> playerNames, LadderInfo ladderInfo) {
        return new LadderGameInfo(playerNames, ladderInfo);
    }

    public static LadderGameInfo of(List<String> playerNames, int ladderHeight) {
        LadderSize ladderSize = LadderSize.of(getLadderWidth(playerNames), ladderHeight);
        LadderInfo ladderInitInfo = LadderInfo.of(ladderSize, getRandomLineCreateStrategy());

        return new LadderGameInfo(playerNames, ladderInitInfo);
    }

    private static int getLadderWidth(List<String> players) {
        return players.size();
    }

    public Players getPlayers() {
        return players;
    }

    public LadderInfo getLadderInfo() {
        return ladderInfo;
    }
}
