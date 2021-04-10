package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final static String RESULT_SEPARATOR = ",";
    private final List<Result> results;

    public Results(String values) {
        this.results = generateResults(values.split(RESULT_SEPARATOR));
    }

    private List<Result> generateResults(String[] values) {
        return IntStream.range(0, values.length)
                .mapToObj(position -> new Result(values[position], position))
                .collect(Collectors.toList());
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public List<String> values() {
        return results.stream()
                .map(Result::value)
                .collect(Collectors.toList());
    }

    public static Results from(String value) {
        return new Results(value);
    }
}
