package ladder.domain;

import static ladder.domain.Point.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Line {
    private static final Random random = new Random();
    
    private final Points points;

    protected Line(final int countOfPerson) {
        points = new Points(createPoints(countOfPerson * 2 - 1));
    }
    
    protected Line(final Points points) {
        this.points = points;
    }

    public int getEndIndex(int startIndex) {
        return points.getEndIndex(startIndex);
    }

    public int getOrderByNextLine(int nextLineIndex) {
        return points.getNextLineOrderBy(nextLineIndex);
    }

    public int getNextLineIndexBy(int order) {
        return points.getVerticalIndex(order);
    }
    
    public List<Point> getPoints() {
        return Collections.unmodifiableList(points.getAll());
    }
    
    private List<Point> createPoints(int length) {
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
