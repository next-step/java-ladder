package ladder.domain.ladder;

import ladder.domain.ladder.direction.HorizontalLineDirection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LadderLineTest {

    @Test
    void create() {
        HorizontalLineDirection first = HorizontalLineDirection.first().get(0);
        HorizontalLineDirection last = first.last();

        LadderLine ladderLine = new LadderLine(first, last);

        assertThat(ladderLine).isEqualTo(new LadderLine(first, last));
    }
}
