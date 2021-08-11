package nextstep.ladder.domain.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results of(final List<Result> results) {
        return new Results(results);
    }

    public static Results of(final String results) {
        return new Results(Arrays.stream(results.split(","))
            .map(Result::of)
            .collect(Collectors.toList()));
    }

    public Result get(final int index) {
        return results.get(index);
    }

    public List<Result> getValues() {
        return Collections.unmodifiableList(results);
    }
}
