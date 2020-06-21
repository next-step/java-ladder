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

    public Point moveToRight() {
        XAxis xAxis = this.xAxis.move(1);
        return Point.of(xAxis, this.yAxis);
    }

    public Point moveToLeft() {
        XAxis xAxis = this.xAxis.move(-1);
        return Point.of(xAxis, this.yAxis);
    }

    public Point moveToDown() {
        YAxis yAxis = this.yAxis.move(1);
        return Point.of(this.xAxis, yAxis);
    }
}
