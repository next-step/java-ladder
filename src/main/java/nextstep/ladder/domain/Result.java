package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> result;

    public Result(List<String> result) {
        this.result = result;
    }

    public static Result ofByRaw(String resultsRaw) {
        String[] splitResultsRaw = resultsRaw.split(",");
        List<String> result = new ArrayList<>();
        for (String resultRaw : splitResultsRaw) {
            result.add(resultRaw.trim());
        }
        return new Result(result);
    }

    public List<String> getResult() {
        return result;
    }

    public String getResultByOrder(int order) {
        return result.get(order);
    }
}
