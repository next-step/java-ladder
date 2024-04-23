package nextstep.ladder;

public class Position {
    private final int position;
    private final Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int move() {
        return this.position + this.direction.move();
    }
}
