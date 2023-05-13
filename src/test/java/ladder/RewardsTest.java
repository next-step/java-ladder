package ladder;

import ladder.model.Reward;
import ladder.model.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    @DisplayName("게임 실행 결과를 생성할 수 있다")
    @Test
    void create() {
        Rewards rewards = Rewards.of(List.of("1000", "꽝"));
        assertThat(rewards.getRewards().get(0)).isEqualTo(new Reward("1000"));
        assertThat(rewards.getRewards().get(1)).isEqualTo(new Reward("꽝"));
    }
}
