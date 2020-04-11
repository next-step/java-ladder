package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRewardsTest {
    @DisplayName("사다리 Reward 생성 시 , 로 구분한다")
    @Test
    void create() {
        LadderRewards ladderRewards = LadderRewards.of("꽝,5000,꽝,3000");

        assertThat(ladderRewards.getLadderRewards()).containsExactly(
                LadderReward.of("꽝"),
                LadderReward.of("5000"),
                LadderReward.of("꽝"),
                LadderReward.of("3000"));
    }
}
