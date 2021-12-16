package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    void 사다리_생성() {
        int ladderSize = 5;
        int playerCount = 3;
        Ladder ladder = new Ladder(ladderSize, playerCount);
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.size()).isEqualTo(ladderSize);
    }
}
