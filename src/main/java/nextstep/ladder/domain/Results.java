package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Results {

    private static final int ZERO = 0;

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

    public Map<Result, Integer> mapResultIndex() {
        Map<Result, Integer> resultMap = new LinkedHashMap<>();

        IntStream.range(ZERO, results.size())
                .forEach(index -> resultMap.put(results.get(index), index));
        return resultMap;
    }

    public List<Result> getResults() {
        return results;
    }
}
