package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("특정 지점에서 연결된 점이 있다면 이동된 지점이 리턴되고," +
                 " 연결된 점이 없다면 동일한 지점이 리턴된다.")
    public void moveTrueTest() {
        Point p0 = Point.in(0);
        Point p1 = Point.in(1);
        Point p2 = Point.in(2);
        p0.connect(p1);

        List<Point> points = Arrays.asList(p0, p1, p2);
        Line line = Line.of(points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
