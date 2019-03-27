package laddergame.domain;

import laddergame.validator.EndPointValidator;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class EndPoint extends Point {

    private final String name;

    public EndPoint(String name, int index) {
        super(index, Direction.of(FALSE, FALSE));
        new EndPointValidator().validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndPoint endPoint = (EndPoint) o;
        return Objects.equals(name, endPoint.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%5s", name);
    }
}