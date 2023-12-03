package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.horizontallinecreationstrategy.FixedHorizontalLineStrategy;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        FixedHorizontalLineStrategy fixedHorizontalLineStrategy = new FixedHorizontalLineStrategy(true);
        String[] memberNames = {"aaaa", "bbb", "ccc"};
        InputResults inputResults = new InputResults(new String[]{"꽝", "5000", "꽝"}, memberNames);
        LadderGame ladderGame = new LadderGame(fixedHorizontalLineStrategy, memberNames, inputResults);
        int heightOfLadder = 2;

        assertThat(ladderGame.generateLadder(heightOfLadder).horizontalLines()).isEqualTo(
            List.of(new HorizontalLine(true, false), new HorizontalLine(true, false)));
    }
}
