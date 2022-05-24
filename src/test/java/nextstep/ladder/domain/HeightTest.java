package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

  @Test
  @DisplayName("사다리 높이 생성")
  void create() {
    assertThat(new Height("5")).isEqualTo(new Height(5));
  }

  @Test
  @DisplayName("사다리 높이 1보다 작을 경우 예외")
  void givenLessThanOne_ShouldBeException() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
  }
}