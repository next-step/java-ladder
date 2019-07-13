package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    private Results(List<String> results) {
        this.results = results.stream().map(Result::of).collect(Collectors.toList());
    }

    public static Results of(String results){
        return new Results(Arrays.stream(results.split(",")).collect(Collectors.toList()));
    }

    public List<Result> getResults() {
        return results;
    }
}
