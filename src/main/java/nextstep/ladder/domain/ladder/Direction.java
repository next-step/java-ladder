package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    private boolean currentPointStatus;
    private boolean nextPointStatus;

    public Direction(boolean currentPointStatus, boolean nextPointStatus) {
        this.currentPointStatus = currentPointStatus;
        this.nextPointStatus = nextPointStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return currentPointStatus == direction.currentPointStatus &&
                nextPointStatus == direction.nextPointStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPointStatus, nextPointStatus);
    }
}
