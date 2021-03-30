package ladder.dto;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return results;
    }

    public Result result(int resultIndex) {
        return results.get(resultIndex);
    }
}
