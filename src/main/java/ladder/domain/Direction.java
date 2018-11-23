package ladder.domain;

public enum Direction {
    RIGHT(1, "  |--"),
    LEFT(-1, "--|  "),
    NONE(0, "  |  ");

    private int step;
    private String description;

    Direction(int step, String description) {
        this.step = step;
        this.description = description;
    }

    public static boolean isNone(Direction direction) {
        return direction == NONE;
    }

    public static int findPosition(Direction direction) {
        return direction.step;
    }

    @Override
    public String toString() {
        return description;
    }
}
