package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void not_overlap_lines_of_ladder() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(true, true, false));
    }
}
