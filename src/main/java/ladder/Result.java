package ladder;

import java.util.Objects;

public class Result {
    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    public void validate(String result) {
        if(result.isBlank()) {
            throw new IllegalArgumentException("결과는 빈 값일수없습니다.");
        }
        if( result.length() > 5) {
            throw new IllegalArgumentException("결과는 5글자 이상일 수 없습니다.");
        }
    }

    @Override
    public String toString() {
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
