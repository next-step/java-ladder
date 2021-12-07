package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(String[] results) {
        List<Result> list = Arrays.stream(results)
                .map(Result::from)
                .collect(Collectors.toList());

        return new Results(list);
    }

    public Result resultOfIndex(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
