package nextstep.ladder;

import nextstep.ladder.domain.game.LadderResults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineResultTest {

    @Test
    void positionRangeTest() {
        LadderResults ladderResults = new LadderResults("100, 200, 꽝");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderResults.findBy(-1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ladderResults.findBy(3);
        });
    }
}
