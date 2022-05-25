package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

  @Test
  @DisplayName("사다리 높이 생성")
  void create() {
    assertThat(new Height("1")).isEqualTo(new Height(1));
  }

  @DisplayName("사다리 높이 음수 이거나 0일 경우 예외 처리")
  @ParameterizedTest
  @ValueSource(ints = {-1, 0})
  void givenLessThanOne_ShouldBeException(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Height(input));
  }
}