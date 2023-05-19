package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderRewardsTest {

    @DisplayName("사용자 수와 같은 경품들 생성 테스트")
    @Test
    public void create_경품들() {
        LadderRewards ladderRewards = LadderRewards.createRewards("1,꽝,2000000,꽝,20000000000", 5);

        assertAll(
                () -> assertThat(ladderRewards.ladderRewards().get(0).reward()).isEqualTo("1"),
                () -> assertThat(ladderRewards.ladderRewards().get(1).reward()).isEqualTo("꽝"),
                () -> assertThat(ladderRewards.ladderRewards().get(2).reward()).isEqualTo("2000000"),
                () -> assertThat(ladderRewards.ladderRewards().get(3).reward()).isEqualTo("꽝"),
                () -> assertThat(ladderRewards.ladderRewards().get(4).reward()).isEqualTo("20000000000")
        );
    }

    @DisplayName("사용자 수와 다른 경품들 생성 시 오류")
    @Test
    public void create_사용자_수와_다른_경품들() {
        assertThatThrownBy(() -> LadderRewards.createRewards("꽝,1000,꽝,4000", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
