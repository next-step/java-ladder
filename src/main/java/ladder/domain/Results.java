package ladder.domain;

import java.util.List;


public class Results {

    private List<String> results;

    public static Results of(String[] results) {
        return new Results(List.of(results));
    }

    public Results(List<String> results) {
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }

    public int getResultsSize() {
        return results.size();
    }
}
