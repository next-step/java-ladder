package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
            .map(Result::new)
            .collect(Collectors.toList());
    }

    public List<Result> results() {
        return Collections.unmodifiableList(this.results);
    }

    public Result result(int index) {
        return this.results.get(index);
    }

}
