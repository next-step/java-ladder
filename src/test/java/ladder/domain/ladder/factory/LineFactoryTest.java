package ladder.domain.ladder.factory;

import ladder.domain.ladders.ladder.Line;
import ladder.domain.ladders.factory.LineFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineFactoryTest {

    @Test
    void generate_lines() {
        Line line1 = new Line(false, false);
        Line line = new Line(false, false);

        List<Line> actual = LineFactory.generateLines(2, 3, () -> false);
        assertThat(actual)
                .isEqualTo(List.of(line1, line));
    }
}