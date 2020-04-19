package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<Result> results) {
        this.results = Collections.unmodifiableList(new ArrayList<>(results));
    }

    public Results(String[] splitResults) {
        results = Arrays
                .stream(splitResults)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return results;
    }
}
