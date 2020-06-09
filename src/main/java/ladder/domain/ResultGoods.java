package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultGoods {
    private final List<String> results;

    public ResultGoods(String[] results) {
        this.results = Arrays.stream(results).collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results;
    }
}
