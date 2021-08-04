package nextstep.ladder.domain.info;

import nextstep.ladder.domain.GameElement;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResults;

import java.util.List;
import java.util.Objects;

import static nextstep.ladder.domain.strategy.LineCreateStrategyFactory.getRandomLineCreateStrategy;

public class LadderGameInfo {
    private final GameElement gameElement;
    private final LadderInfo ladderInfo;

    private LadderGameInfo(List<String> playerNames, List<String> gameResultNames, LadderInfo ladderInfo) {
        validate(playerNames, gameResultNames, ladderInfo);

        Players players = Players.of(playerNames);
        GameResults gameResults = GameResults.of(gameResultNames);

        this.gameElement = GameElement.of(players, gameResults);
        this.ladderInfo = ladderInfo;
    }

    private void validate(List<String> players, List<String> gameResults, LadderInfo ladderInfo) {
        if (Objects.isNull(players)) {
            throw new IllegalArgumentException("Players는 null이면 안됩니다");
        }

        if (Objects.isNull(gameResults)) {
            throw new IllegalArgumentException("gameResults는 null이면 안됩니다");
        }

        if (Objects.isNull(ladderInfo)) {
            throw new IllegalArgumentException("LadderInfo는 null이면 안됩니다");
        }
    }

    public static LadderGameInfo of(List<String> playerNames, List<String> gameResults, LadderInfo ladderInfo) {
        return new LadderGameInfo(playerNames, gameResults, ladderInfo);
    }

    public static LadderGameInfo of(List<String> playerNames, List<String> gameResults, int ladderHeight) {
        LadderSize ladderSize = LadderSize.of(getLadderWidth(playerNames), ladderHeight);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, getRandomLineCreateStrategy());

        return new LadderGameInfo(playerNames, gameResults, ladderInfo);
    }

    private static int getLadderWidth(List<String> players) {
        return players.size();
    }

    public Players getPlayers() {
        return gameElement.getPlayers();
    }

    public GameResults getGameResults() {
        return gameElement.getGameResults();
    }

    public GameElement getGameElement() {
        return gameElement;
    }

    public LadderInfo getLadderInfo() {
        return ladderInfo;
    }
}
