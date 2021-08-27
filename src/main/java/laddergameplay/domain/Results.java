package laddergameplay.domain;

import laddergameplay.exception.CustomException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    public static final String TOTAL_RESULTS_EXCEPTION_MESSAGE = "실행 결과의 개수를 잘못 입력 하였습니다.";

    private final List<Result> results;

    public Results(List<String> resultsString, People people) {
        results = resultsString.stream()
                .map(Result::new)
                .collect(Collectors.toList());

        validateTotalResults(people);
    }

    private void validateTotalResults(People people) {
        if (results.size() != people.numberOf()) {
            throw new CustomException(TOTAL_RESULTS_EXCEPTION_MESSAGE);
        }
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
