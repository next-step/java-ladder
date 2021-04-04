package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {

    @DisplayName("LadderResult 생성 테스트")
    @Test
    void create_생성_테스트() {
        // given
        LadderRewards ladderRewards = LadderRewards.valueOf("꽝", "5000");
        // when
        LadderRewards expected = LadderRewards.valueOf("꽝", "5000");
        // then
        assertThat(ladderRewards).isEqualTo(expected);
    }
}
