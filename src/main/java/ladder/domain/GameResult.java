package ladder.domain;

import ladder.engine.LadderResult;
import ladder.enums.Numeric;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private String[] gameResults;

    public GameResult(String[] gameResults) {
        this.gameResults = gameResults;
    }

    public String show(int index) {
        return this.gameResults[index / Numeric.TWO.number()];
    }

    public Map allResults(Users users, LadderResult ladderResult) {
        Map<String, String> results = new HashMap<>();
        for (User user : users) {
            int resultPosition = ladderResult.getTarget(user.position());
            String result = this.show(resultPosition);
            results.put(user.name(), result);
        }
        return results;
    }
}
