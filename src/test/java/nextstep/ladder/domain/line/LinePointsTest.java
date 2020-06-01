package nextstep.ladder.domain.line;

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

        assertThatThrownBy(() -> LinePoints.of(points))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
