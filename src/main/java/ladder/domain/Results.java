package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = List.copyOf(results).stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return List.copyOf(results);
    }

    Result getResult(int index) {
        return results.get(index);
    }
}
