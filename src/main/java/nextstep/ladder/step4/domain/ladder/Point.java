package nextstep.ladder.step4.domain.ladder;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        return Move.of(direction).move(this.index);
    }

    public boolean right() {
        return direction.right();
    }

}
