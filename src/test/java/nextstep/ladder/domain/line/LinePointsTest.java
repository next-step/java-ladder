package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinePointsTest {

    @DisplayName("연속적으로 사다리가 존재하면 예외가 발생한다.")
    @Test
    void point_validation() {
        List<Point> points = Arrays.asList(Point.first(() -> true), Point.first(() -> true));

        assertThatThrownBy(() -> new LinePoints(points))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("point가 방향이 오른쪽이면 위치가 1증가한다.")
    @Test
    void right_move() {
        Point first = Point.first(() -> true);
        List<Point> points = Arrays.asList(first, first.next(() -> true));
        LinePoints linePoints = new LinePoints(points);

        assertThat(linePoints.move(0)).isEqualTo(1);
    }

    @DisplayName("point가 방향이 왼쪽이면 위치가 1감소한다.")
    @Test
    void left_move() {
        Point first = Point.first(() -> true);
        List<Point> points = Arrays.asList(Point.first(() -> true), first.next(() -> false));
        LinePoints linePoints = new LinePoints(points);

        assertThat(linePoints.move(1)).isEqualTo(0);
    }

}
