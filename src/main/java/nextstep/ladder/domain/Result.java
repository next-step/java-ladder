package nextstep.ladder.domain;

import java.util.function.Consumer;

public class Result {
    private final String value;

    private Result(String value) {
        this.value = value;
    }

    public static Result valueOf(String value) {
        return new Result(value);
    }

    public String getValue() {
        return value;
    }

    public void accept(Consumer<String> consumer) {
        consumer.accept(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        return value.equals(result.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
