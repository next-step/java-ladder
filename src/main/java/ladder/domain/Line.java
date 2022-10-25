package ladder.domain;

import static ladder.domain.Point.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Line {
    private static final Random random = new Random();
    private final int length;

    protected Line(int countOfPerson) {
        length = countOfPerson * 2 - 1;
    }

    public List<Point> points() {
        List<Point> points = new ArrayList<>();
        points.add(VERTICAL_LINE);

        for (int index = 1; index < length-1; index++) {
            Point point = choice(points.get(index - 1), canAddHorizonNextTime(points), index == length - 2);
            points.add(point);
        }

        points.add(VERTICAL_LINE);
        return points;
    }
    
    private Point choice(Point before, boolean canAddHorizonNextTime, boolean isBeforeLast) {
        if (!canAddHorizonNextTime) {
            return BLANK;
        }
        if (isBeforeLast) {
            return choiceBeforeLast(before);
        }
        return point(next(before));
    }

    protected abstract Point choiceBeforeLast(Point before);
        
    protected static Point point(List<Point> points) {
        return points.get(random.nextInt(points.size()));
    }
}
