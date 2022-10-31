package nextstep.domain;

import nextstep.strategy.RandomLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void create_line() {
        Line line = new Line(5, new RandomLineStrategy());
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    void create_line_with_true_strategy() {
        Line line = new Line(5, () -> true);
        List<Boolean> points = line.getPoints();
        assertThat(points).isEqualTo(List.of(true, false, true, false));
    }
}
