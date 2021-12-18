package nextstep.ladder.domain;

import java.util.Objects;

public class Result {
    private static final String EXCEPTION_MESSAGE_RESULT = "결과를 입력하세요.";

    private final String result;

    public Result(String result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(String name) {
        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_RESULT);
        }
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
