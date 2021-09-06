package ladderrefactoring.domain.datas;

import ladderrefactoring.domain.data.Result;
import ladderrefactoring.exception.CustomException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
        if (!people.isSameSizeAs(results.size())) {
            throw new CustomException(TOTAL_RESULTS_EXCEPTION_MESSAGE);
        }
    }

    public List<Result> results() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Results)) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
