package ladder.domain;

import static ladder.domain.Point.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Line {
    private static final Random random = new Random();
    
    private final int length;

    protected Line(final int countOfPerson) {
        length = countOfPerson * 2 - 1;
    }

    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(VERTICAL_LINE);

        for (int index = 1; index < length-1; index++) {
            Point point = choice(points.get(index - 1), canAddHorizonNextTime(points), index == length - 2);
            points.add(point);
        }

        points.add(VERTICAL_LINE);
        return points;
    }
    
    private Point choice(final Point before, final boolean canAddHorizonNextTime, final boolean isBeforeLast) {
        if (!canAddHorizonNextTime) {
            return BLANK;
        }
        if (isBeforeLast) {
            return choiceBeforeLast(before);
        }
        return choicePoint(next(before));
    }

    protected abstract Point choiceBeforeLast(Point before);
        
    protected static Point choicePoint(final List<Point> points) {
        return points.get(random.nextInt(points.size()));
    }
}
