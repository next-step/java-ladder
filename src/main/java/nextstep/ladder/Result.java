package nextstep.ladder;

import java.util.Objects;

public class Result {
    private final static int MIN_POSITION = 0;
    private final String value;
    private final int position;

    private Result(final String value, final int position) {
        validation(position);
        this.value = value;
        this.position = position;
    }

    private void validation(int position) {
        if (position < MIN_POSITION)
            throw new IllegalArgumentException("결과 순번은 0보다 작게 지정할 수 없습니다.");
    }

    public String value() {
        return value;
    }

    public int position() {
        return position;
    }

    public static Result of(String name, int position) {
        return new Result(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return position == result.position && Objects.equals(value, result.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, position);
    }

    @Override
    public String toString() {
        return "Result{" +
                "value='" + value + '\'' +
                ", position=" + position +
                '}';
    }
}
