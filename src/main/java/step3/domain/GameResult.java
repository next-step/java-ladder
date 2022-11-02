package step3.domain;

import java.util.Map;

public class GameResult {

    private static final String ALL_PEOPLE_TEXT = "all";

    private final Map<Integer, Integer> results;

    public GameResult(String name, Users users, Ladder ladder) {
        this.results = calculateResults(name, users, ladder);
    }

    private Map<Integer, Integer> calculateResults(String name, Users users, Ladder ladder) {
        if (name.equals(ALL_PEOPLE_TEXT)) {
            return ladder.getAllResultIndex(users.getUserCounts());
        }
        return ladder.getResultIndex(users.names.indexOf(name));
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }
}
