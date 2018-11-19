package ladder.domain;

import java.util.Objects;

public class Result {
    private String name;

    private Result(String name) {
        this.name = name;
    }

    public static Result of(String name) {
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
