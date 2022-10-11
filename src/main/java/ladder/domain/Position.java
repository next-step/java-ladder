package ladder.domain;

public class Position {
    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 은 음수일 수 없습니다.");
        }

        this.position = position;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    public Position moveRight() {
        return new Position(position + 1);
    }

    public Position moveLeft() {
        return new Position(position - 1);
    }

    public boolean isGreaterThan(int position) {
        return this.position > position;
    }

    public boolean isLesserThan(int position) {
        return this.position < position;
    }

    public boolean isGreaterThanEqual(int position) {
        return this.position >= position;
    }
}
