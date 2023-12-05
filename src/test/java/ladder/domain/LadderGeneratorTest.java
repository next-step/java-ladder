package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.horizontallinecreationstrategy.FixedHorizontalLineStrategy;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    @Test
    void 사다리_생성_확인() {
        FixedHorizontalLineStrategy fixedHorizontalLineStrategy = new FixedHorizontalLineStrategy(true);
        String[] memberNames = {"aaaa", "bbb", "ccc"};
        GameResults gameResults = new GameResults(new String[]{"꽝", "5000", "꽝"}, memberNames);
        LadderGenerator ladderGenerator = new LadderGenerator(fixedHorizontalLineStrategy, memberNames, gameResults);
        String heightOfLadder = "2";

        assertThat(ladderGenerator.generateLadder(heightOfLadder).horizontalLines()).isEqualTo(
            List.of(new HorizontalLine(true, false), new HorizontalLine(true, false)));
    }
}
