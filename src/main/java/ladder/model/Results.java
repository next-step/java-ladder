package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private List<Result> results = new ArrayList<>();

    public Results(String inputResults) {
        results = Arrays.stream(inputResults.split(",")).map(Result::new).collect(Collectors.toList());
    }

    public Result findByIndex(int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
