package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderResults {

    private final List<String> results;

    private LadderResults(List<String> results) {
        this.results = results;
    }

    public static LadderResults of(int countOfPersons, List<String> results) {
        validateCount(countOfPersons, results);
        return new LadderResults(results);
    }

    private static void validateCount(int countOfPersons, List<String> results) {
        if (countOfPersons != results.size()) {
            throw new IllegalArgumentException("결과 수가 사람 수와 일치하지 않습니다.");
        }
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
