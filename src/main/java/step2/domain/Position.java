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

    public Position move(int movePosition) {
        return new Position(position += movePosition);
    }

    public int getValue() {
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


}
