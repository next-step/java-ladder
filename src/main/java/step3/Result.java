package step3;


import java.util.Objects;

public class Result {
    private final String value;
    private final Position position;

    public Result(String value, Position position) {
        this.value = value;
        this.position = position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public String toOutputString() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(value, result.value) && Objects.equals(position, result.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, position);
    }
}
