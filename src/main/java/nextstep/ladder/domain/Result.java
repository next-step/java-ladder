package nextstep.ladder.domain;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(String value) {
        if (value == null || value.length() > 5) {
            throw new IllegalArgumentException("결과는 빈값이면 안되며, 최대 5자리입니다.");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
