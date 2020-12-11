package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Results {

    private static final int ZERO = 0;

    private List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results createResults(InputResult inputResult) {
        List<Result> resultList = new ArrayList<>();
        int index = 0;
        for(String result : inputResult.splitResults()) {
            resultList.add(Result.of(result, index++));
        }

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

    public Result confirmResult(int finalIndex) {
        return results.get(finalIndex);
    }

}
