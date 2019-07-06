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
public class Link {
    public static final int INCREASE = 1;
    public static final int DEFAULT_INDEX = 0;
    private static final String CREATE_FIRST_INDEX_EXCEPTION_MESSAGE = "왼쪽노드가 유효하지 않습니다. (0번째 Link의 왼쪽노드는 flase만 허용합니다.)";

    private final int index;
    private final Point point;

    public Link(int index, Point point) {
        if (index == DEFAULT_INDEX && point.left()) {
            throw new IllegalArgumentException(CREATE_FIRST_INDEX_EXCEPTION_MESSAGE);
        }
        this.index = index;
        this.point = point;
    }

    public static Link first(RandomGenerator random) {
        return new Link(DEFAULT_INDEX, new Point(random.generate(), false));
    }

    public static Link next(Link leftLink, RandomGenerator random) {
        return new Link(leftLink.index + INCREASE, new Point(random.generate(), leftLink.point.current()));
    }

    public static Link last(Link leftLink) {
        return new Link(leftLink.index + INCREASE, new Point(false, leftLink.point.current()));
    }

    public boolean matchIndex(int index) {
        return this.index == index;
    }

    public boolean status() {
        return point.current();
    }

    public int move() {
        return index + point.move();
    }
}
