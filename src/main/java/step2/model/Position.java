package step2.model;

public class Position {
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position valueOf(int value) {
        return new Position(value);
    }

    public int getPosition() {
        return position;
    }

    public void move(Movement movement) {
        position += movement.getDirection();
    }

    public int getLeftPosition() {
        return position - 1;
    }

    public int getRightPosition() {
        return position + 1;
    }

}
