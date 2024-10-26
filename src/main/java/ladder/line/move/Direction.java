package ladder.line.move;

public enum Direction {
    PASS("사다리 왼쪽 또는 오른쪽으로 이동 할 수 없는 경우"),
    LEFT("현재 위치에서 사다리 왼쪽으로 이동할 수 있는 경우"),
    RIGHT("현재 위치에서 사다리 오른쪽으로 이동할 수 있는 경우");

    private final String description;

    Direction(String description) {
        this.description = description;
    }
}
