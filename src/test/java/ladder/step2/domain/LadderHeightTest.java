package ladder.step2.domain;

import ladder.step2.exception.LadderHeightMinimumSizeException;
import ladder.step2.exception.LadderHeightNonNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderHeightTest {

  @DisplayName("사다리 높이가 1 미만일 경우 LadderHeightMinimumSizeException 발생")
  @ParameterizedTest
  @ValueSource(ints = {-1, 0})
  void 사다리_높이_검증_테스트 (int height) {
    assertThatExceptionOfType(LadderHeightMinimumSizeException.class)
      .isThrownBy(() -> LadderHeight.valueOf(height));
  }

  @DisplayName("사다리 높이에 대한 입력값이 숫자가 아닐경우 LadderHeightNonNumberException 발생")
  @ParameterizedTest
  @ValueSource(strings = {"a", "!@#", "높이"})
  void 사다리_높이_검증_테스트 (String height) {
    assertThatExceptionOfType(LadderHeightNonNumberException.class)
      .isThrownBy(() -> LadderHeight.valueOf(height));
  }
}
