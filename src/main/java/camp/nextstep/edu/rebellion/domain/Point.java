package camp.nextstep.edu.rebellion.domain;

public class Point {
    private final int x;
    private final int y;
    private boolean prev;
    private boolean next;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean match(int x, int y) {
        return this.x == x && this.y == y;
    }

    public boolean canMark() {
        return this.prev && this.next;
    }

    public void markOnPrev() {
        this.prev = true;
    }

    public void markOnNext() {
        this.next = true;
    }

    public boolean hasPrev() {
        return this.prev;
    }

    public boolean hasNext() {
        return this.next;
    }
}
