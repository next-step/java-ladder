package laddergame.domain.results;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<String> executionResults;

    public Results(final String[] executionResults) {
        this.executionResults = new ArrayList<>(List.of(executionResults));
    }

    public static Results of(final String[] executionResults){
        return new Results(executionResults);
    }

    public List<String> get() {
        return executionResults;
    }

    public String get(final int result) {
        return executionResults.get(result);
    }

    public int getCount() {
        return executionResults.size();
    }
}

