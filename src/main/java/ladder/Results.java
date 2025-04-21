package ladder;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results, Players players) {
        validate(results, players);
        this.results = results;
    }

    public void validate(List<Result> results, Players players) {
        if (results.size() != players.size()) {
            throw new IllegalArgumentException("실행결과와 참여자수가 일치하지 않습니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
