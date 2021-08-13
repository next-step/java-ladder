package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if(left && current) {
            throw new IllegalArgumentException("두쪽 다리가 전부 있을 수는 없습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public Direction move() {
        if(left) {
            return Direction.LEFT;
        }

        if(current) {
            return Direction.RIGHT;
        }

        return Direction.PASS;
    }
}
