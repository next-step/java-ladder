package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {

    public static Ladder create(int numberOfParticipants, int height) {
        return new Ladder(createLines(numberOfParticipants, height));
    }

    private static List<Line> createLines(int numberOfParticipants, int height) {
        return Stream.generate(() -> LadderFactory.createLine(numberOfParticipants))
                .limit(height)
                .collect(Collectors.toList());
    }

    public static Line createLine(int numberOfParticipants) {
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.first();
        points.add(firstPoint);

        boolean previousRight = firstPoint.right();
        for (int i = 1; i < numberOfParticipants - 1; i++) {
            Point currentPoint = Point.middle(previousRight);
            points.add(currentPoint);
            previousRight = currentPoint.right();
        }

        Point lastPoint = Point.last(previousRight);
        points.add(lastPoint);

        return Line.of(Collections.unmodifiableList(points));
    }

}
