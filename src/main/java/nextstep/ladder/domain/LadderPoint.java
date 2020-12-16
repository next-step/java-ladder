package nextstep.ladder.domain;


public class LadderPoint {

    private final Direction direction;

    public LadderPoint(Direction direction) {
        this.direction = direction;
    }

    public static LadderPoint generateFirst(DirectionStrategy directionStrategy) {
        return new LadderPoint(directionStrategy.next());
    }

    public static LadderPoint generateLast(LadderPoint beforeLadderPoint) {
        return new LadderPoint(Direction.of(beforeLadderPoint.direction, false));
    }

    public static LadderPoint generateNext(LadderPoint beforeLadderPoint, DirectionStrategy directionStrategy) {
        if (beforeLadderPoint.direction.isRight()) {
            return new LadderPoint(Direction.LEFT);
        }
        return new LadderPoint(directionStrategy.next());
    }

    public Direction getDirection() {
        return direction;
    }

    public int move(int index) {
        return direction.move(index);
    }
}
