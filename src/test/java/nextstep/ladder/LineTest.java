package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    @DisplayName("가로 라인이 겹치는 경우(내 왼쪽에 있는 Point와 내가 모두 hasLine이 true 이면 안된다.) Exception을 반환한다.")
    void assertPointHasLine() {
        List<Point> points = new ArrayList<>();
        Point point1 = new Point(0, true);
        Point point2 = new Point(1, true);

        points.add(point1);
        points.add(point2);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(points);
        }).withMessage(Point.POINT_HAS_LINE_ERROR);
    }

    /**
     * |-----|     |
     */
    @Test
    @DisplayName("출발점으로부터 알맞은 결과에 도착하는지 확인한다.")
    void playTest() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, true));
        points.add(new Point(1, false));
        Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(2);
    }

    /**
     * |     |-----|
     */
    @Test
    @DisplayName("출발점으로부터 알맞은 결과에 도착하는지 확인한다.")
    void playTest2() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false));
        points.add(new Point(1, true));
        Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(2);
        assertThat(line.move(2)).isEqualTo(1);
    }

    /**
     * |     |     |
     */
    @Test
    @DisplayName("출발점으로부터 알맞은 결과에 도착하는지 확인한다.")
    void playTest3() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false));
        points.add(new Point(1, false));
        Line line = new Line(points);

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(1);
        assertThat(line.move(2)).isEqualTo(2);
    }
}
