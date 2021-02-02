package step2;

import java.util.Objects;

public class Result {

    private static final String NULL_RESULT_MESSAGE = "결과는 1자리 이상이어야 합니다.";

    private final String name;

    private Result(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_RESULT_MESSAGE);
        }
    }

    public static Result newResult(String name) {
        return new Result(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
