package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {

    @DisplayName("LadderResult 생성 테스트")
    @Test
    void create_생성_테스트() {
        // given
        Reward[] paramRewards = {Reward.valueOf("꽝"), Reward.valueOf("5000")};
        LadderRewards ladderRewards = LadderRewards.valueOf(paramRewards);
        // when
        LadderRewards expected = LadderRewards.valueOf(paramRewards);
        // then
        assertThat(ladderRewards).isEqualTo(expected);
    }
}
