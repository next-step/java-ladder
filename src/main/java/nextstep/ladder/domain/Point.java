package nextstep.ladder.domain;

public class Point {

    private int index;
    private Direction direction;

    private Point(int index, Direction direction) {
        checkFirstDirection(index, direction);
        this.index = index;
        this.direction = direction;
    }

    public static Point from(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getNextPoint() {
        return index + direction.getDirectionIndex();
    }

    private void checkFirstDirection(int index, Direction direction) {
        if(index == 0 && direction == Direction.LEFT) {
            throw new IllegalArgumentException("첫 방향은 왼쪽일 수 없습니다.");
        }
    }
}
