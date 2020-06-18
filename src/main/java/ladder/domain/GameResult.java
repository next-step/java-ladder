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
        for (Map.Entry<Person, Result> entry : gameResult.entrySet()) {
            Person person = entry.getKey();
            Result value = entry.getValue();
            if (person.getName().equals(name)) {
                return value.getResult();
            }
        }
        return "찾는 결과 없음";
    }
}
