package nextstep.ladder.domain;

import java.util.Objects;

public class Result {

    private final String value;

    public Result(String result) {
        this.value = result;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Result result1 = (Result) obj;
        return Objects.equals(value, result1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
