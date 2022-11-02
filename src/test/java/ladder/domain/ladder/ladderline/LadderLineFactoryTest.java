package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.testutil.LadderLineTestUtil.createNoneLadderLine;
import static org.assertj.core.api.Assertions.*;

class LadderLineFactoryTest {

    private LadderLineFactory ladderLineFactory;

    @BeforeEach
    void setUp() {
        this.ladderLineFactory = new LadderLineFactory(new LadderNotContinuousConnectStrategy()) {
            @Override
            protected HorizontalLineDirection randomConnectableLadder(
                    HorizontalLineDirection beforeHorizontalLineDirection) {
                return HorizontalLineDirection.NONE;
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
        LadderLine ladderLine = new LadderLine(
                List.of(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE, HorizontalLineDirection.NONE));

        assertThat(createNoneLadderLine(3)).isEqualTo(ladderLine);
    }
}
