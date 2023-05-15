package nextstep.ladder.domain;

import nextstep.ladder.dto.LineDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;
    public Line(int countOfPerson, Connector connector) {
        this.points = new ArrayList<>();
        for (int i = 1; i < countOfPerson; i++) {
            points.add(connect(connector));
        }
    }

    public Line(List<Boolean> expected) {
        this.points = new ArrayList<>(expected);
    }

    private boolean connect(Connector connector) {
        if (canConnectPoints()) {
            return connector.connect();
        }
        return false;
    }

    private boolean canConnectPoints() {
        if (points.isEmpty()) {
            return true;
        }
        return !points.get(points.size() - 1);
    }

    public static Line of(int countOfPerson, Connector connector) {
        return new Line(countOfPerson, connector);
    }

    public LineDto toDto() {
        return new LineDto(points);
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
