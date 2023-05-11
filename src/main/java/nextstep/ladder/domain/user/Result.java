package nextstep.ladder.domain.user;

import nextstep.ladder.domain.formatter.Formatter;
import nextstep.ladder.domain.formatter.NameFormatter;

import java.util.Objects;

public class Result {

    private final String value;
    private final Formatter formatter;

    public Result(String value) {
        this(value, new NameFormatter());
    }

    public Result(String value, Formatter formatter) {
        this.value = value;
        this.formatter = formatter;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return formatter.format(value);
    }

}
