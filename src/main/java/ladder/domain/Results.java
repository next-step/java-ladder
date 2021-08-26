package ladder.domain;

import ladder.exception.NullValueException;
import ladder.exception.PersonCountException;
import ladder.exception.ResultsLengthException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private static final String RESULTS_IS_NULL_EXCEPTION_COMMENT = "결과값 리스트 객체값이 널입니다.";
    private static final String RESULTS_LENGTH_EXCEPTION_COMMENT = "결과값 리스트의 길이가 0이하 입니다.";
    private static final String RESULTS_DIFFERENT_FROM_PERSON_COUNT_EXCEPTION_COMMENT = "결과값 리스트의 크기와 사람인원수가 다릅니다.";

    private final List<Result> results;

    private Results(List<Result> results, int countOfPerson) {
        validate(results, countOfPerson);
        this.results = results;
    }

    private static Results of(List<Result> results, int countOfPerson) {
        return new Results(results, countOfPerson);
    }

    public static Results of(String results, int countOfPerson) {
        nullCheck(results);
        return of(Arrays.stream(results.split(","))
            .map(result -> Result.from(result.trim()))
            .collect(Collectors.toList()), countOfPerson);
    }

    private static void nullCheck(String results) {
        if (Objects.isNull(results)) {
            throw new NullValueException(RESULTS_IS_NULL_EXCEPTION_COMMENT);
        }
    }

    private void validate(List<Result> results, int countOfPerson) {
        if (results.size() <= 0) {
            throw new ResultsLengthException(RESULTS_LENGTH_EXCEPTION_COMMENT);
        }

        if (results.size() != countOfPerson) {
            throw new PersonCountException(RESULTS_DIFFERENT_FROM_PERSON_COUNT_EXCEPTION_COMMENT);
        }
    }

    public List<String> toStringList() {
        return results.stream()
            .map(Result::result)
            .collect(Collectors.toList());
    }
}
