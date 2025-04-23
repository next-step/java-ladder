package nextstep.ladder;

import ladder.Ladder;
import ladder.PointStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {
    @Test
    void 사다리_이동() {
        PointStrategy strategy = new FixPointStrategy(List.of(true, false, true, false, true, false, false, false));
        Ladder ladder = new Ladder(1, 5, strategy);
        Assertions.assertThat(ladder.move(0)).isEqualTo(1);
    }
}
