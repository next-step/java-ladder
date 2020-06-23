package nextstep.ladder.domain;

import java.util.Objects;

public class YAxis {

    private int yAxis;

    private YAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public static YAxis of(int yAxis) {
        return new YAxis(yAxis);
    }

    public YAxis move(int yAxis) {
        return YAxis.of(this.yAxis + yAxis);
    }

    @Override
    public String toString() {
        return String.valueOf(this.yAxis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.yAxis);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        YAxis yAxis = (YAxis) obj;
        return Objects.equals(yAxis.yAxis, this.yAxis);
    }
}
