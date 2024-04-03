package ladder;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리_생성() {
        Ladder ladder = new Ladder(5, 4);
        assertThat(ladder).isNotNull();
    }
}
