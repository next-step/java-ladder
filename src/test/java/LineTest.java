import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {
    @Test(expected = IllegalArgumentException.class)
    public void 포인트_개수_1개이하일때() {
        // given
        LineGenerator lineGenerator = new RandomLineGenerator();
        // when
        Line line = lineGenerator.generate(0);
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void 포인트가_연속으로_연결되어있을때() {
        // given
        List<Point> points = Arrays.asList(Point.notLinkedPoint, Point.linkedPoint, Point.linkedPoint);
        // when
        Line line = new Line(points);
        // then
    }
}
