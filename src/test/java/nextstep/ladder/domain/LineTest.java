package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("사다리 한 라인을 확인한다.")
    @Test
    void create() {

        final Point point = Point.first(true);
        final List<Point> points = List.of(point
                , point.next(false)
                , point.next(true)
        );
        final Line line = new Line(points);

        assertThat(line).isEqualTo(new Line(points));
    }
}
