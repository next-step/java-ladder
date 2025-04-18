package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> values) {
        this.results = values.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Result getResult(int index) {
        return results.get(index);
    }
}
