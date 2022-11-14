package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void of() {
        Ladder ladder = new Ladder(5, 4);
        assertThat(ladder.height()).isEqualTo(5);
        assertThat(ladder.getLines().get(0).size()).isEqualTo(4);
    }
}
