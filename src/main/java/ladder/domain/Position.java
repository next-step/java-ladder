package ladder.domain;

public class Position {

    private final int number;

    public Position(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public int number() {
        return number;
    }
}
