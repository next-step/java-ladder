package step2.model;

import java.util.*;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(Users users, Results results) {
        gameResults = new ArrayList<>();

        for (int i = 0; i < users.getNumberOfUsers(); i++) {
            gameResults.add(new GameResult(users.getUser(i), results.getResult(i)));
        }
    }

    public LinkedHashMap<String, String> allUsersResults() {
        LinkedHashMap<String, String> allResults = new LinkedHashMap<>();

        gameResults.forEach(gameResult ->
                                allResults.put(gameResult.getUserName(), gameResult.getGameResult()));

        return allResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }
}
