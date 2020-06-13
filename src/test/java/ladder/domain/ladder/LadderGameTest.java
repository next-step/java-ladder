package ladder.domain.ladder;

import ladder.domain.strategy.FalseLineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderGameTest {

    @Test
    void findAllResult() {
        LadderGame ladderGame = new LadderGame(Ladder.of(5,5, new FalseLineStrategy()));

        List<Integer> result = ladderGame.findAllPosition(5);

        assertThat(result.get(0)).isEqualTo(0);
        assertThat(result.get(1)).isEqualTo(1);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(3);
        assertThat(result.get(4)).isEqualTo(4);
    }
}
