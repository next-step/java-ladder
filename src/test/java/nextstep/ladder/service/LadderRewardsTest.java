package nextstep.ladder.service;

import nextstep.ladder.domain.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("사다리 타기 결과 값 찾기 테스트")
    @Test
    void findReward_테스트() {
        // given
        LadderRewards ladderRewards = LadderRewards.valueOf("꽝", "5000");

        // then
        assertAll(
                () -> assertThat(ladderRewards.findReward(0)).isEqualTo(Reward.valueOf("꽝")),
                () -> assertThat(ladderRewards.findReward(1)).isEqualTo(Reward.valueOf("5000"))
        );

    }
}
