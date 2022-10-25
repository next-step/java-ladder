package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderLineFactoryTest {

    @Test
    void create() {
        LadderLineFactory ladderLineFactory = new LadderLineFactory(new LadderNotContinuousConnectStrategy()){
            @Override
            protected Ladder randomConnectableLadder(Ladder beforeLadder) {
                return Ladder.NONE;
            }
        };
        LadderLine actual = ladderLineFactory.randomLadderLine(new LadderWidth(3));

        Assertions.assertThat(actual).isEqualTo(new LadderLine(List.of(Ladder.NONE,Ladder.NONE,Ladder.NONE)));
    }
}
