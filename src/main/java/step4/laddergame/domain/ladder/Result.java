/*
* 결과 하나를 의미하는 클래스
* */
package step4.laddergame.domain.ladder;

import java.util.Objects;

public class Result {
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private static final String ILLEGAL_RESULT = "결과값은 길이가 1~5이어야합니다.";

    private final String result;

    public Result(String result) {
        validResult(result);
        this.result = result;
    }

    public static Result of(String result) {
        return new Result(result);
    }

    private void validResult(String result) {
        if(isEmpty(result) || result.length() > MAXIMUM_RESULT_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_RESULT);
        }
    }

    private boolean isEmpty(String result) {
        return result == null || result.isEmpty() || result.equals("");
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append(result)
                .toString();
    }
}
