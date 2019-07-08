package nextstep.step4.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 03:11
 */
public class Point {
    public static final int INCREASE = 1;
    public static final int DEFAULT_INDEX = 0;
    private static final String CREATE_FIRST_INDEX_EXCEPTION_MESSAGE = "왼쪽노드가 유효하지 않습니다. (0번째 Link의 왼쪽노드는 flase만 허용합니다.)";

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        if (index == DEFAULT_INDEX && direction.left()) {
            throw new IllegalArgumentException(CREATE_FIRST_INDEX_EXCEPTION_MESSAGE);
        }
        this.index = index;
        this.direction = direction;
    }

    public Point next(RandomGenerator random) {
        return new Point(index + INCREASE, direction.next(random.generate()));
    }

    public static Point first(RandomGenerator random) {
        return new Point(DEFAULT_INDEX, new Direction(false, random.generate()));
    }

    public static Point last(Point leftPoint) {
        return new Point(leftPoint.index + INCREASE, new Direction(leftPoint.direction.current(), false));
    }

    public boolean matchIndex(int index) {
        return this.index == index;
    }

    public boolean isDirectionRight() {
        return direction.moveDirection();
    }

    public int move() {
        return index + direction.move();
    }
}
