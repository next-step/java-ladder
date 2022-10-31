package nextstep.step2.domain;

public class Point {
    private boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public static Point from(boolean point) {
        return new Point(point);
    }

    public boolean value(){
        return point;
    }
}
