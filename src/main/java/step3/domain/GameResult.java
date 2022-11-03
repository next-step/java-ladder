package step3.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {

    private final Map<String, String> gameResults;

    public GameResult(Users users, Results results, Ladders ladders) {
        this.gameResults = calculateGameResults(users, results, ladders);
    }

    private Map<String, String> calculateGameResults(Users users, Results results, Ladders ladders) {
        Map<Integer, Integer> indexMap = ladders.getAllResultIndex(users.getUserCounts());

        return indexMap.entrySet().stream().collect(Collectors.toMap(
                it -> users.getNames().get(it.getKey()),
                it -> results.getResults().get(it.getValue())));
    }

    public Map<String, String> getGameResults() {
        return new HashMap<>(gameResults);
    }
}
