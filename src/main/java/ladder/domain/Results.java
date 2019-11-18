package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {
    private static final String COMMA_DELIMITER = ",";

    private Map<Integer, Result> results = new HashMap<>();

    public Results(String resultsInput) {
        splitByDelimiter(resultsInput);
    }

    private void splitByDelimiter(String resultsInput) {
        results = Stream.of(resultsInput.split(COMMA_DELIMITER))
                .map(Result::new)
                .collect(Collectors.toMap());
    }

    public int countOfResults() {
        return results.size();
    }

    public Map<Integer, Result> getResults() {
        return results;
    }
}
