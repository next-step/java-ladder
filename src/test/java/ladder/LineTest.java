package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void createLine() {
        Line line = new Line(4);
        assertThat(line.hasSize(4)).isTrue();
    }
}
