package nextstep.ladder.domain.line;

import nextstep.ladder.domain.BooleanGenerator;
import nextstep.ladder.domain.member.Member;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.domain.line.point.Points;

import java.util.List;
import java.util.Objects;

public class Line {
    private static final String STICK = "|";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final Points points;

    Line(List<Boolean> points) {
        this(Points.of(points));
    }

    Line(Points points) {
        this.points = points;
    }

    public Line(Members members, BooleanGenerator booleanGenerator) {
        this(Points.of(members, booleanGenerator));
    }

    public String getPoint() {
        return this.points.getPoint() +
                STICK +
                LINE_SEPARATOR;
    }

    public void move(Member member) {
        member.move(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
