package nextstep.ladder.domain;

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
        if (index % 2 == 0) {
            return new Part(PartDirection.VERT);
        }
        return new Part(PartDirection.HORZ);
    }

    @Override
    public String toString() {
        return "{" + isConnected +
            ", " + partDirection + '}';
    }
}