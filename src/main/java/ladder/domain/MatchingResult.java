package ladder.domain;

import ladder.domain.engine.Rewards;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {

    private final Map<Integer, Integer> matchingResult;

    private MatchingResult(Map<Integer, Integer> matchingResult) {
        this.matchingResult = new HashMap<>(matchingResult);
    }

    public static MatchingResult of(Map<Integer, Integer> matchingResult) {
        return new MatchingResult(matchingResult);
    }

    public LadderResult map(Players players, Rewards rewards) {
        Map<String, String> ladderResult = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : matchingResult.entrySet()) {
            ladderResult.put(players.get(entry.getKey()), rewards.get(entry.getValue()));
        }
        return LadderResult.of(ladderResult);
    }

}
