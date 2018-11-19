package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderResult {

    private List<Result> results;

    private LadderResult(List<Result> results) {
        this.results = results;
    }

    public static LadderResult ofComma(String result) {
        List<Result> results = Arrays.stream(result.split(","))
                .map(Result::new)
                .collect(Collectors.toList());

        return new LadderResult(results);
    }

    public Result findNthResult(int n) {
        return this.results.get(n);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(this.results);
    }
}
