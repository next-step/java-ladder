package nextstep.ladder.domain;

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
        int remainder = index % 2;

        // 0,2,4,6,8,10 ...
        if (remainder == 0) {
            return new Part(PartDirection.VERT);
        }
        // 1,3,5,7,9,11, ...
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