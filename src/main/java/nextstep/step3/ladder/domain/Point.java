package nextstep.step3.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 12:54
 */
public class Point {
    private final boolean current;
    private final boolean left;

    public Point(boolean current, boolean left) {
        this.current = current;
        this.left = left;
    }

    public boolean current() {
        return current;
    }

    public boolean left() {
        return left;
    }

    @Override
    public String toString() {
        return "Point{" +
                "current=" + current +
                ", left=" + left +
                '}';
    }
}
