package step2.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position of(Position firstPosition, Position secondPosition) {
        int position = firstPosition.getValue() + secondPosition.getValue();
        return new Position(position);
    }

    public void move(int movePosition) {
        position += movePosition;
    }

    public int getBackwardValue() {
        return position - 1;
    }

    public int getValue() {
        return position;
    }

    public boolean isForwardMoveable(int size) {
        if (position == size) {
            return false;
        }

        return true;
    }

    public boolean isBackwardMoveable() {
        if (position - 1 < 0) {
            return false;
        }

        return true;
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


}
