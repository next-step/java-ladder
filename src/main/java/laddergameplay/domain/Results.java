package laddergameplay.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(List<String> resultsString) {
        this.results = resultsString.stream()
                .map(Result::new)
                .collect(Collectors.toList());;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
