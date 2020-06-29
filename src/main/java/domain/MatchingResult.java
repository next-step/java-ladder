package domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {
    private final Map<Integer, Integer> matchingResult;

    private MatchingResult(Map<Integer, Integer> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public static MatchingResult of(Map<Integer, Integer> matchingResult) {
        return new MatchingResult(matchingResult);
    }

    public LadderResult map(Players players, String[] results) {
        Map<String, String> ladderResult = new HashMap<>();
        for (int i = 0; i < players.countOfPlayers(); i++) {
            ladderResult.put(players.getPlayerName(i), results[matchingResult.get(i)]);
        }

        return LadderResult.of(ladderResult);
    }
}
