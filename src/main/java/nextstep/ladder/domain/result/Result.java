package nextstep.ladder.domain.result;

import nextstep.ladder.domain.Position;

import java.util.Objects;

public class Result {

    private final Position position;
    private final ResultName name;

    public Result(String name) {
        this(Position.first(), name);
    }

    public Result(Position position, String name) {
        this.position = position;
        this.name = new ResultName(name);
    }

    public static Result first(String name) {
        return new Result(name);
    }

    public Result next(String name) {
        return new Result(position.nextPosition(), name);
    }

    public boolean equalPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(position, result.position) && Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return name + "  ";
    }
}
