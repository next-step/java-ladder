package nextstep.ladder.domain;

import java.util.Objects;

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

    public XAxis getxAxis() {
        return this.xAxis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xAxis, this.yAxis);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point point = (Point) obj;
        return Objects.equals(point.xAxis, this.xAxis) &&
                Objects.equals(point.yAxis, this.yAxis);
    }
}
