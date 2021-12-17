package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.user.LadderPlayers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ExecutionResults {

    public static final String ERROR_EMPTY_MSG = "리스트가 비어있습니다..";

    private final List<String> results;

    public ExecutionResults(List<String> results) {
        if (Objects.isNull(results) || results.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_MSG);
        }
        this.results = results;
    }

    public ExecutionResults executeGame(LadderPlayers players, Ladder ladder) {
        List<String> gameResult = new ArrayList<>();
        for (int index = 0; index < players.size(); index++) {
            int findIndex = ladder.move(index);
            gameResult.add(this.results.get(findIndex));
        }
        return new ExecutionResults(gameResult);
    }

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
