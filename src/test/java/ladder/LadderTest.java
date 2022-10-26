package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void create() {
        Ladder ladder = Ladder.of(4, 5);
        assertThat(ladder.getLadderLines().size()).isEqualTo(5);
    }
}