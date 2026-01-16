package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void create() {
        List<Boolean> points = List.of(true, false, true, false);

        Line line = new Line(points);

        assertThat(line).isNotNull();
        assertThat(line.getPoints()).hasSize(4);

    }

    @Test
    void move() {
        List<Boolean> points = List.of(true, false, true, false);

        Line line = new Line(points);

        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void 가로선이_연속이면_오류() {
        List<Boolean> points = List.of(true, true, true, false);

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("가로선이 연속될 수 없습니다.");
    }
}
