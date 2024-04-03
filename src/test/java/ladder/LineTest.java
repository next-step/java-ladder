package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 라인_생성() {
        Line line = new Line(5);
        assertThat(line).isNotNull();
    }
}
