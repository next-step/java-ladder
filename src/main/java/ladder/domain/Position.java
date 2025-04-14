package ladder.domain;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid value for Position");
        }

        this.value = value;
    }

    public int value() {
        return value;
    }

    public Position add(int i) {
        return new Position(value + i);
    }

    public Position subtract(int i) {
        return new Position(value - i);
    }

    @Override
    public int hashCode() {
        return value * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Position)) return false;

        Position other = (Position) obj;
        return this.value == other.value();
    }
}
