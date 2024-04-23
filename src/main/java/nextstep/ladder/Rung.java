package nextstep.ladder;

public class Rung {
    private final int position;
    private final Direction direction;

    public Rung(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Rung first(boolean right) {
        return new Rung(0, Direction.first(right));
    }

    public Rung next(boolean right) {
        return new Rung(this.position + 1, this.direction.next(right));
    }

    public Rung next() {
        return new Rung(this.position + 1, this.direction.next());
    }

    public Rung last() {
        return new Rung(this.position + 1, this.direction.last());
    }

    public int move() {
        return this.position + this.direction.move();
    }
}
