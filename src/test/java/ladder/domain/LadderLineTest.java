package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.LadderLine.INVALID_LADDER_LINE_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {

  @Test
  @DisplayName("사다리 라인 size를 입력하여 " +
      "LadderLine을 생성할 수 있으며" +
      "사다리 라인이 정상적으로 생성되는지 검증")
  void ladderLineTest() {
    int given = 5;
    String expected = LadderLine.LINE.repeat(given);

    LadderLine ladderLine = new LadderLine(given);
    assertThat(ladderLine.print()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -100})
  @DisplayName("사다리 라인 size 입력하여 " +
      "LadderLine을 생성 시" +
      "입력된 size 값이 0 또는 음수인 경우 exception 테스트")
  void ladderLineTest2(int given) {
    assertThatThrownBy(() -> new LadderLine(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LADDER_LINE_INPUT, given));
  }
}
