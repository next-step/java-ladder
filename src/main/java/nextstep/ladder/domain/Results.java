package nextstep.ladder.domain;

import java.util.List;

public class Results {
    private List<Result> results;

    public Results(List<Result> results, int personsSize) {
        validate(results, personsSize);
        this.results = results;
    }

    private void validate(List<Result> results, int personSize) {
        if (results.size() != personSize) {
            throw new IllegalArgumentException("실행 결과는 인원수와 동일해야 합니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
