package nextstep.ladder.domain;

import java.util.Objects;

public class Result {
    private final String value;

    public Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
