package nextstep.ladder.domain.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

    private final List<Result> results;

    private GameResults(final List<Result> results) {
        this.results = results;
    }

    public static GameResults of(final List<Result> results) {
        return new GameResults(results);
    }

    public static GameResults of(final String results) {
        return new GameResults(Arrays.stream(results.split(","))
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
