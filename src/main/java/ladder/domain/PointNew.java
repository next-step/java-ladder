package ladder.domain;

public class PointNew {
    private final int index;
    private final DirectionNew directionNew;

    public PointNew(int index, DirectionNew directionNew) {
        this.index = index;
        this.directionNew = directionNew;
    }

    public int nextIndex() {
        return index + 1;
    }

    public boolean hasRightDirection() {
        return directionNew.hasRightDirection();
    }

    public boolean hasLeftDirection() {
        return directionNew.hasLeftDirection();
    }

    public boolean hasDirection() {
        return directionNew.hasDirection();
    }
}
