package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results valueOf(String[] resultNames) {
        List<Result> results = Stream.of(resultNames)
                .map(Result::name)
                .collect(Collectors.toList());
        return new Results(results);
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getName)
                .collect(Collectors.toList());
    }

    public Result get(int resultIdx) {
        return results.get(resultIdx);
    }
}
