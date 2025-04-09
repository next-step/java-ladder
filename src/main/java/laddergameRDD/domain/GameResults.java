package laddergameRDD.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResults {
    private final List<String> users;
    private final List<String> results;

    public GameResults(List<String> users, List<String> results) {
        validateCount(users, results);
        this.users = users;
        this.results = results;

    }

    private void validateCount(List<String> users, List<String> results) {
        if (users.size() != results.size()) {
            throw new IllegalArgumentException("참여자 수와 결과의 개수가 같지 않습니다.");
        }
    }

    public List<GameResult> makeGameResults(Map<Integer, Integer> integerResults) {
        return integerResults.entrySet().stream()
                .map(integerResult -> new GameResult(users.get(integerResult.getKey()), results.get(integerResult.getValue())))
                .collect(Collectors.toList());
    }


}
