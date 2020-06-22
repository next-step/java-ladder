package nextstep.ladder.domain;

import java.util.Objects;

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

    public int getxAxis() {
        return this.xAxis;
    }

    @Override
    public String toString() {
        return String.valueOf(this.xAxis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xAxis);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        XAxis xAxis = (XAxis) obj;
        return Objects.equals(xAxis.xAxis, this.xAxis);
    }
}
