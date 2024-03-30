package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {

    @Test
    void 라인을_생성한다() {
        int height = 4;
        Line line = new Line(height, new RandomPointGenerator());

        Assertions.assertEquals(height, line.getPoints().size());
    }

    @Test
    void 연속된_사다리다리는_없다() {
        int height = 5;
        Line line = new Line(height, new AlwaysTruePointGenerator());
        List<Boolean> points = line.getPoints();

        for (int i = 0; i < points.size() - 1; i++) {
            Assertions.assertFalse(points.get(i) && points.get(i + 1));
        }
    }
}
