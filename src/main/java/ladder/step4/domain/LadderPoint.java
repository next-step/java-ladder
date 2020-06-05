package ladder.step4.domain;

public class LadderPoint {
    private final int point;
    private final Direction direction;

    private LadderPoint (int point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public static LadderPoint of (int point, Direction direction) {
        return new LadderPoint(point, direction);
    }

    public int move () {
        if (direction == Direction.LEFT) {
            return point - 1;
        }
        if (direction == Direction.RIGHT) {
            return point + 1;
        }
        return point;
    }

    public boolean isRight () {
        return Direction.RIGHT == direction;
    }

    public Direction getDirection () {
        return direction;
    }
}