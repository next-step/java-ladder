package nextstep.ladder.domain.line;

import nextstep.ladder.domain.point.Points;

public class VerticalLine {

    private final Points points;

    public VerticalLine(int length) {
        this.points = new Points(length);
    }

    @Override
    public String toString() {
        return "VerticalLine{" +
                "points=" + points +
                '}';
    }
}
