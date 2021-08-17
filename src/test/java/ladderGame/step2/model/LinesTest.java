package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {
  @DisplayName("사다리 최소 높이값 검증 테스트.")
  @ParameterizedTest
  @ValueSource(ints = {-1,0})
  void limitHeightTest(int height) {
    
    assertThatThrownBy(
        ()->new Lines(height, 1)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("높이값은 최소 1부터 가능합니다.");
  }
}