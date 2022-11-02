package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.MoveHorizontalDirection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LadderLineTest {

    @Test
    void create() {
        MoveHorizontalDirection first = MoveHorizontalDirection.first().get(0);
        MoveHorizontalDirection last = first.last();

        LadderLine ladderLine = new LadderLine(first, last);

        assertThat(ladderLine).isEqualTo(new LadderLine(first, last));
    }
}
