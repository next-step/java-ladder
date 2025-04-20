package nextstep.ladder.domain;

import java.util.Objects;

public class Result {
    private String result;

    public Result(String result) {
        if (result == null || result.isBlank()){
            throw new IllegalArgumentException("결과는 빈 값일 수 없습니다");
        }
        this.result = result;
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
        return Objects.hashCode(result);
    }
}
