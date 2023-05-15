package nextstep.ladder.domain.user;

import nextstep.ladder.domain.formatter.Format;
import nextstep.ladder.domain.formatter.NameFormat;

import java.util.Objects;

public class Result {

    private final String value;
    private final Format format;

    public Result(String value) {
        this(value, new NameFormat());
    }

    public Result(String value, Format format) {
        this.value = value;
        this.format = format;
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
        return format.formalize(value);
    }

}
