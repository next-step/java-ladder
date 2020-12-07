package nextstep.ladder.domain;

public class LadderPoint {

    private final Direction direction;

    public LadderPoint() {
        this.direction = Direction.generateFirst();
    }

    public LadderPoint(LadderPoint before, int ladderIndex, int ladderSize) {
        this.direction = getDirection(before, ladderIndex, ladderSize);
    }

    public Direction getDirection(LadderPoint before, int ladderIndex, int ladderSize) {
        if (ladderIndex == 0) {
            return Direction.generateFirst();
        }
        if (ladderIndex == ladderSize) {
            return Direction.generateLast(before.direction);
        }
        return Direction.next(before.direction);
    }
}
