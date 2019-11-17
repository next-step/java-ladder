package ladder.domain;

import java.util.Objects;

public class Result {

    private String name;
    private int position;

    public Result(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return position == result.position &&
                Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
