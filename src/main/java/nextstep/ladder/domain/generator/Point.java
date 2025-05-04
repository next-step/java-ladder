package nextstep.ladder.domain.generator;

public class Point {
    private final boolean current;
    private final boolean next;

    public Point(boolean current, boolean next) {
        this.current = current;
        this.next = next;
    }

    public boolean isConsecutive() {
        return current && next;
    }

    public boolean current() {
        return current;
    }

    public boolean next() {
        return next;
    }
}