package ladder.domain.ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderTest {

    @Test
    void createLadder() {
        int ladderHeight = 5;

        Ladder ladder = Ladder.of(5, ladderHeight, new TrueLineStrategy());

        assertThat(ladder.height()).isEqualTo(ladderHeight);
    }
}