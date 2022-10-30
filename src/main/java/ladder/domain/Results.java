package ladder.domain;

import java.util.Arrays;
import java.util.List;

import static ladder.utils.StringUtils.RESULT_REGEX;

public class Results {

    private List<String> results;

    public static Results of(String results) {
        return new Results(Arrays.asList(results.split(RESULT_REGEX)));
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
