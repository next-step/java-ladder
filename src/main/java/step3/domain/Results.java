package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String RESULT_SIZE_EXCEPTION = "실행결과는 참여인원과 동일하게 입력되어야 합니다.";
    private static final String RESULT_LENGTH_EXCEPTION = "실행결과는 5글자까지 가능합니다.";
    private static final int RESULT_MAX_LENGTH = 5;

    private final List<String> results;

    public Results(List<String> results, int userCounts) {
        validateResultSize(results, userCounts);
        this.results = results;

    }

    private void validateResultSize(List<String> results, int userCounts) {
        if (results.isEmpty() || results.size() != userCounts) {
            throw new IllegalArgumentException(RESULT_SIZE_EXCEPTION);
        }

        for (String result : results) {
            checkResultsLengths(result);
        }
    }

    private void checkResultsLengths(String result) {
        if (result.length() == 0 || result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(RESULT_LENGTH_EXCEPTION);
        }
    }

    public List<String> getResults() {
        return new ArrayList<>(results);
    }
}
