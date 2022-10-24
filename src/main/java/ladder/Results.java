package ladder;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Results {
    private List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .collect(toList());
    }

    public Results(String... results) {
        this.results = Arrays.stream(results)
                .map(Result::new)
                .collect(toList());
    }

    public Result findResultOf(int index) {
        return results.get(index);
    }

}
