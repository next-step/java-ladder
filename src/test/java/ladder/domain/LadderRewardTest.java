package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderRewardTest {

  @ParameterizedTest(name = "꽝 또는 금액 경품 생성 테스트")
  @ValueSource(strings = {"1000", "꽝"})
  public void create_경품(String input) {
    LadderReward ladderReward = new LadderReward(input);
    assertThat(ladderReward.reward()).isEqualTo(input);
  }

  @Test
  @DisplayName("꽝 또는 금액 아닐 시 IllegalArgumentException throw")
  public void create_오류_경품() {
    assertThatThrownBy(() -> new LadderReward("100a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("금액 또는 꽝만 입력이 가능합니다. 현재 입력된 경품 : 100a");
  }
}
