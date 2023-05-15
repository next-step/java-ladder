package nextstep.laddergame.domain.ladder;

public class Position {
    private final int position;
    private final Direction direction;

    private Position(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public int moveResult() {
        return this.position + this.direction.move();
    }

    public boolean isLeftDirection() {
        return this.direction.isLeftDirection();
    }

    public static Position first(boolean isPoint) {
        return new Position(0, Direction.first(isPoint));
    }

    public Position next(int index, boolean isPoint) {
        return new Position(index, direction.next(isPoint));
    }

    public Position last(int index) {
        return new Position(index, this.direction.last());
    }
}
