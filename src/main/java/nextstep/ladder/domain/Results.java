package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;
    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results ofByRaw(String resultsRaw) {
        String[] splitResultsRaw = resultsRaw.split(",");
        List<Result> results = new ArrayList<>();
        for (String resultRaw : splitResultsRaw) {
            Result result = Result.of(resultRaw.trim());
            results.add(result);
        }
        return new Results(results);
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(Result::getResultName)
                .collect(Collectors.toList());
    }
}
