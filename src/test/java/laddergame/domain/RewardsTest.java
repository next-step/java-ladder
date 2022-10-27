package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RewardsTest {


    @Test
    @DisplayName("인덱스 조회")
    void get_reward_by_index() {
        //given
        Rewards rewards = new Rewards("꽝,5000,꽝,3000,꽝".split(","));
        //then
        assertThat(rewards.getReward(1)).isEqualTo(new Reward("5000"));
    }

}