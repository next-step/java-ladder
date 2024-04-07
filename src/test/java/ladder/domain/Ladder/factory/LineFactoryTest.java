package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.ConsciousPointPredicate;
import ladder.domain.Ladder.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineFactoryTest {

    @Test
    void generate_lines() {
        Line line1 = new Line(false, false);
        Line line2 = new Line(false, false);

        List<Line> actual = LineFactory.generateLines(2, 3, new ConsciousPointPredicate());
        assertThat(actual)
                .isEqualTo(List.of(line1, line2));
    }
}