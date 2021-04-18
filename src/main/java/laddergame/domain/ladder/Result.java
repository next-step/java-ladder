/*
* 결과 하나를 의미하는 클래스
* */
package laddergame.domain.ladder;

import java.util.Objects;

import static laddergame.util.Message.ILLEGAL_RESULT;

public class Result {
    private final String result;

    public Result(String result) {
        validEmpty(result);
        this.result = result;
    }

    private void validEmpty(String result) {
        if (result == null || result.isEmpty() || result == "") {
            throw new IllegalArgumentException(ILLEGAL_RESULT);
        }
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
