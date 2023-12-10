package ladder;

import ladder.domain.Ladders;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LaddersTest {
    @Test
    void 사다리높이() {
        final int playerSize = 5;
        final int ladderHeight = 5;
        Ladders ladders = new Ladders(playerSize, ladderHeight);

        Assertions.assertThat(ladders.getLadders().size()).isEqualTo(ladderHeight);
    }
}
