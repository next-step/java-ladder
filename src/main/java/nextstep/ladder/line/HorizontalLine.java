package nextstep.ladder.line;

import nextstep.ladder.point.Point;

import java.util.List;

public class HorizontalLine {

    private List<Point> points;

    public HorizontalLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "HorizontalLine{" +
                "points=" + points +
                '}';
    }
}
