package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

public class Line {

    private List<Point> points;

    public Line(Point point){
        this(Arrays.asList(point));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> points() {
        return points;
    }
}
