package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {

    private final List<Result> results;


    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public static Results of(String results) {
        return new Results(createResults(results));
    }

    private static List<Result> createResults(String results) {
        return Stream.of(results.split(","))
            .map(String::trim)
            .map(Result::of)
            .collect(Collectors.toList());
    }
}
