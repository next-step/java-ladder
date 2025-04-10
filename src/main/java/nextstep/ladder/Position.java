package nextstep.ladder;

public class Position {
    private int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
    }

    public void move(Direction direction) {
        int movedValue = value + direction.getValue();
        validate(movedValue);
        this.value = movedValue;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        return value == position.value;
    }
}
