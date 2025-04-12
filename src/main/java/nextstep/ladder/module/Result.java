package nextstep.ladder.module;

import java.util.Objects;

public class Result {

    private final String result;

    public Result(String result) {
        validateResult(result);
        this.result = result;
    }

    public String value() {
        return result;
    }

    private void validateResult(String result) {
        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("결과는 비어있을 수 없습니다.");
        }

        if (result.isBlank()) {
            throw new IllegalArgumentException("결과는 공백이 될 수 없습니다.");
        }

        if (result.length() > 5) {
            throw new IllegalArgumentException("결과는 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Result result = (Result) obj;
        return this.result.equals(result.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
