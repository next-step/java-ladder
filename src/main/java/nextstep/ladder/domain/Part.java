package nextstep.ladder.domain;

import static nextstep.ladder.utils.LadderPartIndexUtils.isVertical;

import java.util.Objects;

public class Part {
    private boolean isConnected = false;
    private final PartDirection partDirection;

    public Part(PartDirection partDirection) {
        this.partDirection = partDirection;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isHorizontalLine() {
        return partDirection.equals(PartDirection.HORZ);
    }

    public void connect() {
        isConnected = true;
    }

    public static Part valueOf(int index) {
        if (isVertical(index)) {
            return new Part(PartDirection.VERT);
        }
        return new Part(PartDirection.HORZ);
    }

    @Override
    public String toString() {
        return "{" + isConnected +
            ", " + partDirection + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Part part = (Part) o;
        return isConnected == part.isConnected && partDirection == part.partDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConnected, partDirection);
    }
}