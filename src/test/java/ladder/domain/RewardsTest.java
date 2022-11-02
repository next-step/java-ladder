package ladder.domain;

import ladder.domain.person.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class RewardsTest {

    @Test
    void results() {
        Rewards rewards = new Rewards("3000", "꽝", "4000");

        assertThat(rewards.rewards()).containsExactly(new Reward("3000"), new Reward("꽝"), new Reward("4000"));
    }

    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    void result() {
        Rewards rewards = new Rewards("3000", "꽝", "4000");

        assertThat(rewards.reward(new Position(1, 0))).isEqualTo(new Reward("꽝"));
    }
}
