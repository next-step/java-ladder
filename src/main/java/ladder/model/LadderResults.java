package ladder.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderResults {
    private final List<LadderResult> results;

    public LadderResults(List<String> results) {
        validateNotEmpty(results);
        this.results = results.stream()
                .map(LadderResult::of)
                .collect(toList());
    }

    private void validateNotEmpty(List<String> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("사다리 실행 결과값이 비었습니다.");
        }
    }

    List<String> getResults() {
        return results.stream()
                .map(LadderResult::getResult)
                .collect(toList());
    }

    int count() {
        return results.size();
    }

    String get(int resultIndex) {
        LadderResult result = results.get(resultIndex);
        return result.getResult();
    }
}
