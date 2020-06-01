package ladder.step2.domain;

import ladder.step2.exception.LadderHeightMinimumSizeException;
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
}
