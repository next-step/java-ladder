package nextstep.refactor_ladder.domain;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.domain.value.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @GetterForUI
    public List<Point> getPoints() {
        return Collections.unmodifiableList(new ArrayList<>(points));
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
