package nextstep.step4.domain;

public class Point {
    private final boolean previous;
    private final boolean current;

    private Point(boolean previous, boolean current) {
        validateDirection(previous, current);
        this.previous = previous;
        this.current = current;
    }

    public static Point setFirst(MoveStrategy moveStrategy) {
        return new Point(false, moveStrategy.move(false));
    }

    public Point setNext(MoveStrategy moveStrategy) {
        return new Point(this.current, moveStrategy.move(this.current));
    }

    public Point setLast() {
        return new Point(this.current, false);
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
