package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        this(LineFactory.createLine(countOfPerson, lineStrategy));
    }

    public Line(List<Boolean> points) {
        this(new ArrayList<>(points), new ArrayList<>(), new ArrayList<>());
    }

    public Line(List<Boolean> points, List<Point> ladderPoints, List<Position> positions) {
        this.points = new ArrayList<>(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }


    public boolean getLine(int idx) {
        return points.get(idx);
    }

    public int size() {
        return points.size();
    }

    public Line getLine() {
        return this;
    }
}
