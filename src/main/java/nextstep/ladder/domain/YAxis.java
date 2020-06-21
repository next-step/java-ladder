package nextstep.ladder.domain;

public class YAxis {

    private int yAxis;

    private YAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public static YAxis of(int yAxis) {
        return new YAxis(yAxis);
    }
}
