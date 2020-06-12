package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class ResultGoods {
    private final List<String> results;

    public ResultGoods(String[] results) {
        this.results = Arrays.asList(results);
    }

    public List<String> getResults() {
        return results;
    }
}
