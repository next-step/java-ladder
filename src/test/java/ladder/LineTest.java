package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE));
        line = new Line(points);
    }

    @Test
    void 라인_객체_테스트() {
//        Line line2 = new Line(4);
//        assertThat(line).isNotEqualTo(line2);
    }
}
