package nextstep.step4.domain;

public class Point {
    private final boolean previous;
    private final boolean current;

    public Point(boolean previous, boolean current) {
        validateDirection(previous, current);
        this.previous = previous;
        this.current = current;
    }

    private void validateDirection(boolean previous, boolean current) {
        if(previous && current) {
            throw new IllegalArgumentException("이전 방향이 오른쪽인데 현재 방향도 오른쪽일 수는 없습니다.");
        }
    }

    public Direction move() {
        if(current) {
            return Direction.RIGHT;
        }

        if(previous) {
            return Direction.LEFT;
        }

        return Direction.FORWARD;
    }
}
