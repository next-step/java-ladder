package nextstep.ladder;

public class Rung {
    private final int position;
    private final Direction direction;

    public Rung(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int move() {
        return this.position + this.direction.move();
    }
}
