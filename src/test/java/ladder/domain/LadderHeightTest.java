package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.LadderHeight.INVALID_LADDER_HEIGHT_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

  @Test
  @DisplayName("사다리 높이를 입력하여 " +
      "LadderHeight를 생성할 수 있으며" +
      "사다리 높이가 정상적으로 저장되는지 검증")
  void ladderHeightTest() {
    int given = 5;
    LadderHeight ladderHeight = new LadderHeight(given);
    assertThat(ladderHeight.height()).isEqualTo(given);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -100})
  @DisplayName("사다리 높이를 입력하여 " +
      "LadderHeight를 생성 시" +
      "입력 값이 0 또는 음수인 경우 exception 테스트")
  void ladderHeightTest2(int given) {
    assertThatThrownBy(() -> new LadderHeight(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LADDER_HEIGHT_INPUT, given));
  }
}
