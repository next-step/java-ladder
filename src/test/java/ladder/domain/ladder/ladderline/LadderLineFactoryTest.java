package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ladder.ladderline.LadderLineTestUtil.createNoneLadderLine;
import static org.assertj.core.api.Assertions.*;

class LadderLineFactoryTest {

    private LadderLineFactory ladderLineFactory;

    @BeforeEach
    void setUp() {
        this.ladderLineFactory = new LadderLineFactory(new LadderNotContinuousConnectStrategy()) {
            @Override
            protected Ladder randomConnectableLadder(Ladder beforeLadder) {
                return Ladder.NONE;
            }
        };
    }

    @Test
    void random_ladderlines() {
        LadderLines actual = ladderLineFactory.randomLadderLines(new LadderWidth(2), new LadderHeight(2));

        assertThat(actual)
                .isEqualTo(new LadderLines(List.of(createNoneLadderLine(2), createNoneLadderLine(2))));
    }

    @Test
    void random_ladderline() {
        assertThat(createNoneLadderLine(3)).isEqualTo(new LadderLine(List.of(Ladder.NONE, Ladder.NONE, Ladder.NONE)));
    }
}
