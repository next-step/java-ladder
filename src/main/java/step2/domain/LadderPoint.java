package step2.domain;

public class LadderPoint {
    private int index;
    private Direction direction;

    public LadderPoint(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getIndex() {
        return index;
    }
}
