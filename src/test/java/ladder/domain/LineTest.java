package ladder.domain;

import ladder.domain.Ladder.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    void not_overlap_lines_of_ladder() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(true, true, false));
    }
}
