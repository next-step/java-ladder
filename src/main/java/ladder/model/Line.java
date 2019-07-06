package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String MESSAGE_OF_MINIMUM_POINTS_EXCEPTION = "Line의 Point 갯수는 최소 다음 이상이어야 합니다.: ";
    public static final int MINIMUM_NUMBER_OF_POINTS = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int numberOfPoints) {
        if (numberOfPoints < MINIMUM_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(String.valueOf(
                    new StringBuilder(MESSAGE_OF_MINIMUM_POINTS_EXCEPTION).append(MINIMUM_NUMBER_OF_POINTS)));
        }

        final Point first = Point.firstOfRandom();
        points.add(first);

        Point next = first;
        for (int i = 0; i < numberOfPoints - MINIMUM_NUMBER_OF_POINTS; i++) {
            next = next.nextOfRandom();
            points.add(next);
        }

        final Point end = next.endOf();
        points.add(end);
    }
}
