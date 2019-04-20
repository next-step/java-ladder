package domain;

import org.junit.Before;
import org.junit.Test;


public class PointTest {
    private Point Point;
    private Level level;

    @Before
    public void firstPoint() {
        level = Level.ADVANCED;
        Point = Point.first(level);
        System.out.print(Point.lineType());
    }

    @Test
    public void nextPoint() {
        System.out.println(Point.next(level).lineType());
    }

    @Test
    public void lastPoint() {
        System.out.println(Point.last(level).lineType());
    }
}
