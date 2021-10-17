package ladder.domain;

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

    public Map allResults(Users users) {
        Map<String, String> results = new HashMap<>();
        for (User user : users) {
            String result = this.show(user.position());
            results.put(user.name(), result);
        }
        return results;
    }
}
