package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRewardsTest {
    @DisplayName("사다리 Reward 생성 시 , 로 구분한다.")
    @Test
    void create() {
        LadderRewards ladderRewards = LadderRewards.of("꽝,5000,꽝,3000");

        assertThat(ladderRewards.getReward(Position.of(0))).isEqualTo(new LadderReward("꽝"));
        assertThat(ladderRewards.getReward(Position.of(1))).isEqualTo(new LadderReward("5000"));
        assertThat(ladderRewards.getReward(Position.of(2))).isEqualTo(new LadderReward("꽝"));
        assertThat(ladderRewards.getReward(Position.of(3))).isEqualTo(new LadderReward("3000"));
    }
}
