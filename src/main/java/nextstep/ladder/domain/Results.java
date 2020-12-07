package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results createResults(InputResult inputResult) {
        List<Result> resultList = Arrays.stream(inputResult.splitResults())
                .map(Result::of)
                .collect(Collectors.toList());

        return new Results(resultList);
    }

    public List<Result> getResults() {
        return results;
    }
}
