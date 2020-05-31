package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("라인은 사람수-1개의 포인트를 생성한다.")
    @Test
    void line_create_points() {
        Line line = new Line(LinePointFactory.of(5, new RandomPointGenerator()));
        assertThat(line.getPoints()).hasSize(4);
    }

    @DisplayName("연속적으로 사다리가 존재하면 예외가 발생한다.")
    @Test
    void point_validation() {
        List<Point> points = Arrays.asList(Point.of(true), Point.of(true));

        assertThatThrownBy(() -> new Line(new LinePoints(points)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
