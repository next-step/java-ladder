package ladder.domain;

public class Point {
    private final boolean left;
    private final boolean current;

    public Point(boolean left, boolean current) {
        if(left && current) {
            current = false;
        }
        this.left = left;
        this.current = current;
    }

    public boolean hasHorizontalLine() {
        return current;
    }
}
