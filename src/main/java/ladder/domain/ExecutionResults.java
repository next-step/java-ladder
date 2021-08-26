package ladder.domain;

import ladder.exception.NullValueException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExecutionResults {
    private static final String NOT_EQIAL_SIZE_NAMES_AND_RESILTS_EXCEPTION_COMMENT = "참여할 사람과 실행결과의 개수가 서로 다릅니다.";

    private final List<Name> names;
    private final List<Result> results;

    private ExecutionResults(List<String> names, List<String> results) {
        validate(names, results);

        this.names = names.stream()
            .map(Name::from)
            .collect(Collectors.toList());

        this.results = results.stream()
            .map(Result::from)
            .collect(Collectors.toList());
    }

    public static ExecutionResults of(List<String> names, List<String> results) {
        return new ExecutionResults(names, results);
    }

    private void validate(List<String> names, List<String> results) {
        if (Objects.isNull(names)) {
            throw new NullValueException("names");
        }

        if (Objects.isNull(results)) {
            throw new NullValueException("results");
        }

        if (names.size() != results.size()) {
            throw new IllegalArgumentException(NOT_EQIAL_SIZE_NAMES_AND_RESILTS_EXCEPTION_COMMENT);
        }
    }

    public List<String> toNameStringList() {
        return names.stream()
            .map(Name::name)
            .collect(Collectors.toList());
    }

    public List<String> toResultStringList() {
        return results.stream()
            .map(Result::result)
            .collect(Collectors.toList());
    }

}
