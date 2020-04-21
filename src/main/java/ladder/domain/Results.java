package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results valueOf(String[] resultNames) {
        return Stream.of(resultNames)
                .map(Result::name)
                .collect(collectingAndThen(toList(), Results::new));
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getName)
                .collect(toList());
    }

    public Result get(int resultIdx) {
        return results.get(resultIdx);
    }

    public int size() { return results.size(); }
}
