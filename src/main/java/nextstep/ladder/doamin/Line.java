package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        Preconditions.checkEmpty(points, "points는 필수값입니다.");

        this.points = points;
    }

    public static Line from(List<Boolean> points) {
        return new Line(points);
    }

    @GetterForUI
    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(new ArrayList<>(points));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
