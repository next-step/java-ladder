package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderRewardsTest {

  @Test
  @DisplayName("사용자 수와 같은 경품들 생성 테스트")
  public void create_경품들() {
    LadderRewards ladderRewards = LadderRewards.createRewards("꽝,1000,꽝,4000", 4);


    assertAll(
            () -> assertThat(ladderRewards.rewardByIndex(0).reward()).isEqualTo("꽝"),
            () -> assertThat(ladderRewards.rewardByIndex(1).reward()).isEqualTo("1000"),
            () -> assertThat(ladderRewards.rewardByIndex(2).reward()).isEqualTo("꽝"),
            () -> assertThat(ladderRewards.rewardByIndex(3).reward()).isEqualTo("4000")
    );
  }

  @Test
  @DisplayName("사용자 수와 다른 경품들 생성 시 IllegalArgumentException throw")
  public void create_사용자_수와_다른_경품들() {
    assertThatThrownBy(() -> LadderRewards.createRewards("꽝,1000,꽝,4000", 5))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유저와 경품 수가 같아야 합니다.");
  }
}
