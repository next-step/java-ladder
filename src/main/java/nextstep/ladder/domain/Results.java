package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

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

    public Result confirmResult(int finalIndex) {
        return results.get(finalIndex);
    }

    public List<Result> getResults() {
        return results;
    }

}
