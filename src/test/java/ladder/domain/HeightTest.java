package ladder.domain;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 6, 7, 8, 9, 10})
  void 사다리_높이가_1이상인_경우는_정상적으로_객체_생성(int height) {
    assertThat(new Height(height)).isInstanceOf(Height.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
  void 사다리_높이가_1미만인_경우는_예외_발생(int height) {
    assertThatThrownBy(() -> new Height(height))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사다리 높이는 1 이상이어야 합니다.");
  }



}