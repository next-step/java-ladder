package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public int countOfResult() {
        return results.size();
    }

    public String getNameAt(int idx) {
        return results.get(idx).getName();
    }

    public List<String> getNames() {
        return results.stream()
                .map(Result::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
