package com.seok2.ladder.product.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.ladder.structure.domain.Line;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RewardsTest {

    @Test
    void find() {

        Line bottom1 = Line.of();
        Line bottom2 = Line.of();
        Reward reward1 = Reward.of(Prize.of("꽝"), bottom1);
        Reward reward2 = Reward.of(Prize.of("1000"), bottom2);
        Rewards rewards = Rewards.of(Arrays.asList(reward1, reward2));

        assertThat(rewards.find(bottom1)).isEqualTo(reward1);
        assertThat(rewards.find(bottom2)).isEqualTo(reward2);
    }
}