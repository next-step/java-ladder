package step2;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> resultValues) {
        results = createResults(resultValues);
    }

    private List<Result> createResults(List<String> resultValues) {
        return resultValues.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
