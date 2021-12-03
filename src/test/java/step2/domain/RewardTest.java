package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    @Test
    void 보상을_생성한다() {
        //given
        Reward reward = Reward.of("꽝");
        //when
        //then
        assertThat(reward).isEqualTo(Reward.of("꽝"));
    }
}
