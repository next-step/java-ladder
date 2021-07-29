package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final Players players;
    private final PlayersAndResults playersAndResults;

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, Players players) {
        validate(ladderInitInfo, players);

        this.ladderInitInfo = ladderInitInfo;
        this.players = players;
        this.playersAndResults = null;
    }

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, PlayersAndResults playersAndResults) {
        validate(ladderInitInfo, playersAndResults);

        this.ladderInitInfo = ladderInitInfo;
        this.playersAndResults = playersAndResults;
        this.players = playersAndResults.getPlayers();
    }

    private void validate(LadderInitInfo ladderInitInfo, Players players) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new NullArgumentException(LadderInitInfo.class);
        }

        if (Objects.isNull(players)) {
            throw new NullArgumentException(Players.class);
        }
    }

    private void validate(LadderInitInfo ladderInitInfo, PlayersAndResults playersAndResults) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new NullArgumentException(LadderInitInfo.class);
        }

        if (Objects.isNull(playersAndResults)) {
            throw new NullArgumentException(PlayersAndResults.class);
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

    public static LadderGameInitInfo of(PlayersAndResults playersAndResults, int ladderHeight) {
        LadderSize ladderSize = LadderSize.of(playersAndResults.numberOfPlayers(), ladderHeight);
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize);

        return new LadderGameInitInfo(ladderInitInfo, playersAndResults);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public Players getPlayers() {
        return players;
    }

    public PlayersAndResults getPlayersAndResults() {
        return playersAndResults;
    }
}
