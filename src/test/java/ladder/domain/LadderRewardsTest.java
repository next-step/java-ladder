package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {
    @Test
    void create() {
        assertThat(LadderRewards.of("꽝,3000"))
                .isEqualTo(new LadderRewards(Arrays.asList(new LadderReward("꽝"), new LadderReward("3000"))));
    }
}
