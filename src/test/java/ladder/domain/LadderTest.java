package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void ladder() {
        Ladder ladder = new Ladder(3, 5);

        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getPoints()).hasSize(3);
    }
}
