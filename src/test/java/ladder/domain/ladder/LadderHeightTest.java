package ladder.domain.ladder;

import ladder.domain.LadderHeight;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderHeightTest {

    @Test
    void create() {
        LadderHeight ladderHeight = new LadderHeight(4);

        assertThat(ladderHeight).isEqualTo(new LadderHeight(4));
    }
}
