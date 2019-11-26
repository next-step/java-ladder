package nextstep.ladder.domain;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:48
 */
public class ExecutionResult {

    private static final int MINIMUM_MAXIMUM_VALUE = 5;

    private final List<String> executionResult;

    public ExecutionResult(List<String> executionResult) {
        if (isGreaterThanMaximumValue(executionResult)) {
            throw new InputMismatchException("결과는 다섯글자 이하로 입력해주세요.");
        }

        this.executionResult = executionResult;
    }

    private boolean isGreaterThanMaximumValue(List<String> participant) {
        return participant.stream()
                .anyMatch(name -> name.length() > MINIMUM_MAXIMUM_VALUE);
    }

    public List<String> getExecutionResult() {
        return this.executionResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionResult that = (ExecutionResult) o;
        return Objects.equals(executionResult, that.executionResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionResult);
    }
}