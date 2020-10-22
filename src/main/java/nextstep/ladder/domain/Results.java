package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getReward)
                .map(Reward::getReward)
                .collect(Collectors.toList());
    }
}
