package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RewardTest {
    @Test
    void 생성_비교() {
        Reward reward = new Reward("꽝");
        assertThat(reward.getReward()).isEqualTo("꽝");
    }

    @Test
    void 결과_미입력() {
        assertThatThrownBy(() -> {
            new Reward("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
