package ladder.domain;

import java.util.Objects;

public class Result {

    private static final int DEFAULT_RESULT_SIZE = 5;
    private final String result;

    public Result(String result) {
        validate(result.length());

        this.result = result;
    }

    private void validate(int length) {
        if (length > DEFAULT_RESULT_SIZE) {
            throw new IllegalArgumentException("결과는 5글자 이상 입력할 수 없습니다.");
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
        return this.result;
    }
}
