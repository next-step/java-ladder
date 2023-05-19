package ladder.model;

public class Position {
    private static final int MINIMUM_POSITION = 0;

    private final int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException("위치는 음수값일 수 없습니다.");
        }
    }

    public int right() {
        return this.position + 1;
    }

    public int left() {
        return this.position - 1;
    }

    public boolean validateRight(Position position) {
        return this.position + 1 == position.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    public int getPosition() {
        return this.position;
    }
}
