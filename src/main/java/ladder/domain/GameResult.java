package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class GameResult {
    private final Map<Person, Result> gameResult;

    private GameResult(Map<Person, Result> gameResult) {
        this.gameResult = gameResult;
    }

    public static GameResult valueOf(Map<Person, Result> gameResult) {
        return new GameResult(gameResult);
    }

    public Map<Person, Result> getGameResult() {
        return Collections.unmodifiableMap(gameResult);
    }

    public String findResult(String name) {
        return gameResult.entrySet().stream()
                .filter(result -> result.getKey().getName().equals(name))
                .map(result -> result.getValue().getResult())
                .findFirst()
                .orElseGet(() -> "없는 참가자 입니다.");
    }
}
