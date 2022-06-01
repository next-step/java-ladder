package ladder.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void createRandomLadder() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.height()).isEqualTo(4);
    }


}
