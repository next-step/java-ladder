package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.InvalidDirectionParameterException;

import java.util.Objects;

public class Direction {
    private boolean currentPointStatus;
    private boolean nextPointStatus;

    public Direction(boolean currentPointStatus, boolean nextPointStatus) {
        validate(currentPointStatus, nextPointStatus);
        this.currentPointStatus = currentPointStatus;
        this.nextPointStatus = nextPointStatus;
    }

    public void validate(boolean currentPointStatus, boolean nextPointStatus) {
        if (currentPointStatus && nextPointStatus) {
            throw new InvalidDirectionParameterException("Can not make direction by both true");
        }
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
