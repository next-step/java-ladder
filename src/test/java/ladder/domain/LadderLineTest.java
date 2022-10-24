package ladder.domain;

import ladder.domain.Ladder.LadderLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = new LadderLine();

        assertThat(ladderLine).isEqualTo(new LadderLine());
    }
}
