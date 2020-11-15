package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private static final double PROBABILTY_HAVING_POINT = 0.5;
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
    }

    public static Line withPerson(int countOfPerson) {
        Stream<Boolean> pointsStream = Stream.iterate(false, Line::getPoint);
        return new Line(pointsStream.limit(countOfPerson)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList))
        );
    }

    private static Boolean getPoint(Boolean hasPrevPoint) {
        if (hasPrevPoint) {
            return false;
        }
        return getRandomPoint();
    }

    private static Boolean getRandomPoint() {
        return Math.random() > PROBABILTY_HAVING_POINT;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
