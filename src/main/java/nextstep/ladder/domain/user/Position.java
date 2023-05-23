package nextstep.ladder.domain.user;

import nextstep.ladder.domain.ladder.ConnectionType;

import java.util.Objects;

public class Position {

    private final int currentPosition;

    public Position(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position move(Position movePosition) {
        return new Position(currentPosition + movePosition.currentPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return currentPosition == position.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }

    public boolean isFirst() {
        return currentPosition == 0;
    }

    public Position beforePosition() {
        return ConnectionType.LEFT.applyPosition(this);
    }

}
