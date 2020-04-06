package JavaLadder.domain;

public class Point {
    private int point = 0;

    public Point(int point) {
        this.point = point;
    }

    public Point() {
        this.point = 0;
    }

    public int getPoint() {
        return this.point;
    }

    public void leftMove() {
        this.point--;
    }

    public void RightMove() {
        this.point++;
    }
}
