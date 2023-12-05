package ladder.domain;

public enum Direction {
    LEFT,
    RIGHT,
    DOWN;

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양방향 모두가 이동가능할 수는 없습니다.");
        }

        if (left) {
            return Direction.LEFT;
        }

        if (right) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }

}
