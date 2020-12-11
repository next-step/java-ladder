package step3.domain;

public enum Direction {
    BRIDGE("-----"),
    NONE("     ");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
