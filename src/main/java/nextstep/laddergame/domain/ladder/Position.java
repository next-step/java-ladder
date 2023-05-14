package nextstep.laddergame.domain.ladder;

public class Position {
    private final int position;
    private final Direction direction;

    public Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int moveResult() {
        return this.position + this.direction.move();
    }

    public boolean isRightDirection() {
        return this.direction.isRightDirection();
    }
}
