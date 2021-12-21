package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<String> results;

    private Results(List<String> results) {
        this.results = results;
    }

    public static Results of(String names) {
        String[] resultsString = names.split(",");
        List<String> results = Arrays.stream(resultsString)
                .collect(Collectors.toList());
        return new Results(results);
    }

    public int countOfResult() {
        return results.size();
    }

}
