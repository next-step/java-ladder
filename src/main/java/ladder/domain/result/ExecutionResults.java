package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.user.LadderPlayers;

import java.util.*;

public class ExecutionResults {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";

    private final List<String> results;

    public ExecutionResults(List<String> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.results = results;
    }

//    public Map<String, String> executeGame(LadderPlayers players, Ladder ladder) {
//        Map<String, String> result = new HashMap<>();
//        for (int num = 0; num < players.size(); num++) {
//            int findIndex = ladder.move(num);
//            result.put(players.getPlayerNames().get(num), this.results.get(findIndex));
//        }
//        return result;
//    }

    public List<String> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExecutionResults that = (ExecutionResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}
