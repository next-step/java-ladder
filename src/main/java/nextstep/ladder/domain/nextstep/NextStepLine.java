package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.engine.Line;

import java.util.List;

public class NextStepLine implements Line {

    private final List<Point> points;

    public NextStepLine(List<Point> points) {
        this.points = List.copyOf(points);

    }

    @Override
    public int move(int index) {
        return points.get(index).move();
    }
}
