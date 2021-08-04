package nextstep.ladder.domain.result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameResults {
    private final List<GameResult> gameResults;

    private GameResults(List<String> results) {
        validate(results);

        this.gameResults = results.stream()
                .map(GameResult::of)
                .collect(Collectors.toList());
    }

    private void validate(List<String> gameResults) {
        if (Objects.isNull(gameResults)) {
            throw new IllegalArgumentException("game results는 null이면 안됩니다");
        }
    }

    public static GameResults of(List<String> results) {
        return new GameResults(results);
    }

    public List<String> getGameResultValues() {
        return gameResults.stream()
                .map(GameResult::getResult)
                .collect(Collectors.toList());
    }

}
