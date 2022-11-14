package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result find(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return this.results;
    }
}
