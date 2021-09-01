package ladder.domain;

import ladder.exception.NotFoundUserException;

import java.util.Collections;
import java.util.List;

public class MatchResults {
    public final List<Result> results;

    public MatchResults(List<Result> results) {
        this.results = results;
    }

    public Result resultToUser(User user) {
        return results.stream()
                .filter(result -> result.getUser().equals(user))
                .findFirst()
                .orElseThrow(() -> new NotFoundUserException("유저를 찾지 못했어요"));
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
