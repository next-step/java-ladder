package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderLineFactoryTest {

    private LadderLineFactory ladderLineFactory;

    @BeforeEach
    void setUp() {
        this.ladderLineFactory = new LadderLineFactory(new LadderNotContinuousConnectStrategy()){
            @Override
            protected Ladder randomConnectableLadder(Ladder beforeLadder) {
                return Ladder.NONE;
            }
        };
    }

    @Test
    void create() {
        LadderLine actual = ladderLineFactory.randomLadderLine(new LadderWidth(3));

        Assertions.assertThat(actual).isEqualTo(new LadderLine(List.of(Ladder.NONE,Ladder.NONE,Ladder.NONE)));
    }
}
