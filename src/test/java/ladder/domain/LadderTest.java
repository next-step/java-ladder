package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리() {
        Ladder ladder = Ladder.from(5, 4);
        assertThat(ladder).isNotNull();
    }
}