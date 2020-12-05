package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ladder.domain.LadderGameConfig.CONNECTED_DELIMITER;
import static ladder.domain.LadderGameConfig.NOT_CONNECTED_DELIMITER;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points){
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(List<Point> points) {

        String pointsValue = points.stream()
                .map(point -> point.isConnected() ? CONNECTED_DELIMITER: NOT_CONNECTED_DELIMITER)
                .collect(Collectors.joining());

        if(pointsValue.contains(CONNECTED_DELIMITER+CONNECTED_DELIMITER)){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_LINE_POINTS.getErrorMessage());
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
