package camp.nextstep.edu.nextstep8.ladder;

public class Point {
    private boolean left;
    private boolean right;

    public Point() {
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
}
