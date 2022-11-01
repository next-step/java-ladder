package ladder;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .collect(toList());
    }

    public Result findResultOf(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

}
