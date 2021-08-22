package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("하나의 라인을 생성한다.")
    @Test
    void create() {
        List<Point> points = Arrays.asList(
            new Point(Direction.RIGHT),
            new Point(Direction.LEFT),
            new Point(Direction.STRAIGHT)
        );

        Line line = new Line(points);
        assertThat(line).isEqualTo(new Line(points));
    }

}
