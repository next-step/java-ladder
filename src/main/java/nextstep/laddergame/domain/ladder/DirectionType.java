package nextstep.laddergame.domain.ladder;

public enum DirectionType {
    PASS(() -> 0),
    LEFT(() -> -1),
    RIGHT(() -> 1);

    private final MoveStrategy moveStrategy;

    DirectionType(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public static DirectionType checkDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽이 전부 연결된 사다리는 이동할 수 없습니다.");
        }

        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return PASS;
    }

    public int moveRow() {
        return moveStrategy.move();
    }
}
