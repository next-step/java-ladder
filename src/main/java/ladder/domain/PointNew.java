package ladder.domain;

import java.util.Objects;

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

    public int move() {
        if (directionNew.hasRightDirection()) {
            return index + 1;
        }
        if (directionNew.hasLeftDirection()) {
            return index - 1;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointNew pointNew = (PointNew) o;
        return index == pointNew.index && Objects.equals(directionNew, pointNew.directionNew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, directionNew);
    }
}
