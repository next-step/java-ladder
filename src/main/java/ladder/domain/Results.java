package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> values) {
        this.results = values.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public void validateSize(int expectedSize) {
        if (results.size() != expectedSize) {
            throw new IllegalStateException("참가자 수와 결과 수가 일치해야 합니다.");
        }
    }

    public Result getResult(int index) {
        return results.get(index);
    }

    public List<Result> list() {
        return Collections.unmodifiableList(results);
    }
}
