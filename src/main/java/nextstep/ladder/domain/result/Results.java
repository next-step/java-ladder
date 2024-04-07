package nextstep.ladder.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public static Results createResults(List<String> results) {
        return new Results(results.stream()
            .map(Result::new)
            .collect(Collectors.toList()));
    }

    public Result findResult(int userIndex) {
        return results.get(userIndex);
    }

    public int size(){
        return results.size();
    }
}
