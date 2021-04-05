package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @DisplayName("보상 객체 생성 테스트")
    @Test
    void create_생성테스트() {
        // given
        Reward reward = Reward.valueOf("꽝");
        // when
        Reward expected = Reward.valueOf("꽝");
        // then
        assertThat(reward).isEqualTo(expected);
    }
}
