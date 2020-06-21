package nextstep.ladder.domain;

public class XAxis {

    private int xAxis;

    private XAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public static XAxis of(int xAxis) {
        return new XAxis(xAxis);
    }

    public XAxis move(int xAxis) {
        return XAxis.of(this.xAxis + xAxis);
    }
}
