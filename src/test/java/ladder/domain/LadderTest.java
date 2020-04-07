package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void ladder() {
        Ladder ladder = new Ladder(3, 5, Arrays.asList("꽝","5000","꽝","3000"));

        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getActions()).hasSize(3);
    }

    @Test
    void getResult() {
        Ladder ladder = new Ladder(3, 5, Arrays.asList("꽝","5000","꽝","3000"));
        ladder.getReward(1);
    }
}
