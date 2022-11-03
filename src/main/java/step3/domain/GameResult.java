package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private static final String ALL_PEOPLE_TEXT = "all";

    private final Map<Integer, Integer> results;

    public GameResult(String name, Users users, Ladders ladder) {
        this.results = calculateGameResults(name, users, ladder);
    }

    private Map<Integer, Integer> calculateGameResults(String name, Users users, Ladders ladder) {
        if (name.equals(ALL_PEOPLE_TEXT)) {
            return ladder.getAllResultIndex(users.getUserCounts());
        }
        return ladder.getOneResultIndex(users.getNames().indexOf(name));
    }

    public Map<Integer, Integer> getGameResults() {
        return new HashMap<>(results);
    }
}
