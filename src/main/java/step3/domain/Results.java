package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> results, int namesSize) {
        validateResults(results.size(), namesSize);
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateResults(int resultsSize, int namesSize) {
        if (resultsSize != namesSize) {
            throw new IllegalArgumentException("입력한 이름과 같은 개수의 결과값이 필요합니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }

    public Result get(int index) {
        return results.get(index);
    }
}
