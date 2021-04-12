package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    private Results(String[] values) {
        this.results = generateResults(values);
    }

    private List<Result> generateResults(String[] values) {
        return IntStream.range(0, values.length)
                .mapToObj(position -> new Result(values[position].trim(), position))
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

    public static Results from(String values) {
        return new Results(StringUtils.stringToArrays(values));
    }
}
