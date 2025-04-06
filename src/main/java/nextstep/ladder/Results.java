package nextstep.ladder;

import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(List<Result> results, int nameCount) {
        if (results.isEmpty()) {
            throw new IllegalArgumentException("결과는 비어있을 수 없습니다.");
        }
        if (results.size() != nameCount) {
            throw new IllegalArgumentException("결과의 개수는 이름의 개수와 같아야 합니다.");
        }
        return new Results(results);
    }
}
