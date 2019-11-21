package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Results {
    private static final String COMMA_DELIMITER = ",";

    private List<Result> results = new ArrayList<>();

    public Results(String resultsInput) {
        splitByDelimiter(resultsInput);
    }

    private void splitByDelimiter(String resultsInput) {
        String[] splitedResults = resultsInput.split(COMMA_DELIMITER);

        IntStream.range(0, splitedResults.length)
                .mapToObj(index -> new Result(index, splitedResults[index]))
                .forEach(results::add);
    }

    public int countOfResults() {
        return results.size();
    }

    public List<Result> getResults() {
        return results;
    }

    public String getResultName(int moveResultPosition) {
        return results.get(moveResultPosition).getName();
    }
}
