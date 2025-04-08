package ladder;

import ladder.domain.Ladder;
import ladder.generator.RandomBridgeGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    public void 플레이어_수와_높이를_기반으로_사다리를_생성한다() {
        int players = 5;
        int height = 5;

        Ladder ladder = Ladder.generateLadder(players, height, new RandomBridgeGenerator());
        int actual = ladder.getLadderHeight();

        assertThat(actual).isEqualTo(height);
    }

}
