package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Line {

    private static final String CONNECTED_DELIMITER = "-";
    private static final String NOT_CONNECTED_DELIMITER = " ";
    private final List<Point> points;

    public Line(List<Point> points){
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {

        String pointsValue = points.stream()
                .map(point -> point.getDirection().isRight() ? CONNECTED_DELIMITER: NOT_CONNECTED_DELIMITER)
                .collect(Collectors.joining());

        if(pointsValue.contains(CONNECTED_DELIMITER+CONNECTED_DELIMITER)){
            throw new IllegalArgumentException("사다리 가로라인은 겹칠 수 없습니다.");
        }

    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
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
