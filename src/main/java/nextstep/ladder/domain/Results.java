package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(String inputResults) {
        if (inputResults == null || inputResults.trim().isEmpty()) {
            throw new IllegalArgumentException("결과가 없습니다");
        }

        this.results = Arrays.stream(inputResults.split(","))
                .map(String::trim)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public List<Result> getResults() {
        return results;
    }
}
