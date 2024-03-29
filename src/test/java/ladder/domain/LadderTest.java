package ladder.domain;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @Test
    void not_overlap_lines_of_ladder() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(true, true, false));
    }
}