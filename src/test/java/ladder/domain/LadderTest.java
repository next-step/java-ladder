package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private LadderReward reward;

    @BeforeEach
    void setUp() {
        reward = new LadderReward("꽝,5000,꽝,3000", 4);
    }

    @Test
    void ladder() {
        Ladder ladder = new Ladder(3, 5, reward);

        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getActions()).hasSize(3);
    }

    @Test
    void getReward() {
        Ladder ladder = new Ladder(3, 5, reward);

        String actual = ladder.getReward(1);

        assertThat(actual).isEqualTo("꽝");
    }
}
