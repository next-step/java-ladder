package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResults;

import java.util.List;
import java.util.Objects;

public class GameElement {
    private final Players players;
    private final GameResults gameResults;

    private GameElement(Players players, GameResults gameResults) {
        validate(players, gameResults);
        this.players = players;
        this.gameResults = gameResults;
    }

    private void validate(Players players, GameResults gameResults) {
        if (Objects.isNull(players)) {
            throw new IllegalArgumentException("이름 players는 null이면 안됩니다.");
        }

        if (Objects.isNull(gameResults)) {
            throw new IllegalArgumentException("이름 players는 null이면 안됩니다.");
        }
    }

    public static GameElement of(Players players, GameResults gameResults) {
        return new GameElement(players, gameResults);
    }

    public static GameElement of(List<String> playersNames, List<String> resultsValues) {
        Players players = Players.of(playersNames);
        GameResults results = GameResults.of(resultsValues);

        return new GameElement(players, results);
    }

    public Players getPlayers() {
        return players;
    }

    public GameResults getGameResults() {
        return gameResults;
    }
}
