package nextstep.domain;

import java.util.List;

public class InputResults {

    private final List<String> results;

    public InputResults(List<String> results, int sizeOfNames) {
        validateResultSize(results, sizeOfNames);
        this.results = results;
    }

    private void validateResultSize(List<String> results, int sizeOfNames) {
        if (results.size() != sizeOfNames) {
            throw new IllegalArgumentException("결과의 크기가 유저이름의 개수는 같아야 합니다.");
        }
    }

    public List<String> getResults() {
        return results;
    }
}
