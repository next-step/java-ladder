package ladder.domain.strtegy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.strtegy.BooleanRandomLineGenerator.INVALID_LADDER_LINE_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BooleanRandomLineGeneratorTest {

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -100})
  @DisplayName("사다리 라인 size 입력하여 " +
      "LadderLine을 생성 시" +
      "입력된 size 값이 0 또는 음수인 경우 exception 테스트")
  void booleanRandomLineGeneratorTest(int given) {
    BooleanRandomLineGenerator generator = new BooleanRandomLineGenerator();
    assertThatThrownBy(() -> generator.generate(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_LADDER_LINE_INPUT, given));
  }
}