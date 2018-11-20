package ladder.domain;

public enum Direction {
    RIGHT("  |--"),
    LEFT("--|  "),
    NONE("  |  ");

    private String description;

    Direction(String description) {
        this.description = description;
    }

    public static boolean isNone(Direction direction) {
        return direction == NONE;
    }

    @Override
    public String toString() {
        return description;
    }
}
