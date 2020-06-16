package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rewards 클래스 테스트")
public class RewardsTest {

    @DisplayName("여러 Reward를 생성 할 수 있다.")
    @Test
    void create() {
        String reward = "꽝";
        String rewards = reward + ",5000,꽝,3000";
        Rewards actual = new Rewards(Arrays.stream(rewards.split(",")).collect(Collectors.toList()));

        assertThat(actual.getRewards().get(0)).isEqualTo(new Reward(reward));
    }
}
