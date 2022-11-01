package ladder;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_게임_검증() {
        Row first = new Row(List.of(true, false, false));
        Row second = new Row(List.of(false, true, false));
        Row third = new Row(List.of(true, false, false));
        Ladder ladder = new Ladder(List.of(first, second, third));
        LadderResult result = ladder.play(3);
        Assertions.assertThat(result.getTarget(0)).isEqualTo(2);
        Assertions.assertThat(result.getTarget(1)).isEqualTo(1);
        Assertions.assertThat(result.getTarget(2)).isEqualTo(0);
    }
}
