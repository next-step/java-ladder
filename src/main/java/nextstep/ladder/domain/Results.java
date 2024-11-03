package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(String[] results) {
        this.results = Arrays.stream(results).map(Result::new).collect(Collectors.toList());
    }


    public List<Result> getResults() {
        return results;
    }

    public Result search(int index) {
        return results.get(index);
    }

    public int resultSize() {
        return results.size();
    }
}
