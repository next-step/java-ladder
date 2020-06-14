package ladder.domain.reward;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {

    private String[] rewards;

    @BeforeEach
    void init() {
        this.rewards = new String[]{"꽝", "5000", "꽝", "3000"};
    }

    @Test
    void LadderRewardsCreateTest() {
        LadderRewards ladderRewards = LadderRewards.inputRewards(rewards);

        assertThat(ladderRewards.getLadderRewards().size()).isEqualTo(4);
    }
}