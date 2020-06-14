package camp.nextstep.edu.nextstep8.ladder.entity;

public class Point {
    private final int x;
    private final int y;
    private boolean left;
    private boolean right;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.left = false;
        this.right = false;
    }

    public boolean isEnd() {
        return left;
    }
    public boolean isStart() {
        return right;
    }
    public void markStart() {
        this.right = true;
    }
    public void markEnd() {
        this.left = true;
    }

    public boolean match(int x, int y) {
        if(this.x == x && this.y == y) {
            return true;
        }
       return false;
    }

    public boolean meetLast(int last) {
        if(last <= y + 1) {
            return true;
        }
        return false;
    }
}
