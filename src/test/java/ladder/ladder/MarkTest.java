package ladder.ladder;
import static org.assertj.core.api.Assertions.*;

import ladder.domain.ladder.Mark;
import org.junit.jupiter.api.Test;

public class MarkTest {
    @Test
    void drawMarkTest() {
        assertThat(Mark.createByNumber(0).draw()).isEqualTo("|");
        assertThat(Mark.createByNumber(1).draw()).isEqualTo("-----|");
    }

    @Test
    void ofLadderTest() {
        assertThat(Mark.ofLadder(0)).isEqualTo("|");
        assertThat(Mark.ofLadder(1)).isEqualTo("-----|");
    }
}
