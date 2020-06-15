package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("Line 이 정상적으로 생성되는지 확인하는 테스트")
    void LineCreateTest() {
        List<Point> points = new ArrayList<>();

        Point first = Point.first(false);
        Point next = first.next(true);
        Point last = next.last();

        points.add(first);
        points.add(next);
        points.add(last);
        Line line = new Line(points);

        List<Point> points1 = line.getPoints();
        assertThat(points1.size()).isEqualTo(3);
    }
}
