package nextstep.ladder.domain;

public class Point {

    private XAxis xAxis;
    private YAxis yAxis;

    private Point(XAxis xAxis, YAxis yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public static Point of(XAxis xAxis, YAxis yAxis) {
        return new Point(xAxis, yAxis);
    }

    public void moveToRight() {

    }

    public void moveToLeft() {

    }

    public void moveToDown() {

    }
}
