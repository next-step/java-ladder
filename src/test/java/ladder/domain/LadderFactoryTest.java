package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    @Test
    void shouldGenerateLadder() {
        Ladder ladder = LadderFactory.getLadder(2, new LadderLength(2), new LineGenerator(() -> false));

        assertThat(ladder.getLadderLength()).isEqualTo(new LadderLength(2));
        assertThat(ladder.getLines().size()).isEqualTo(2);
    }

}
