package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LengthTest {

  @DisplayName("입력된 숫자를 가진 Length를 생성한다.")
  @Test
  void create() {
    Length length = new Length(10);
    assertThat(length.getValue()).isEqualTo(10);
  }

  @DisplayName("1보다 작은 길이로 Length를 생성하려하면 예외가 발생한다.")
  @Test
  void createWithNegative() {
    assertThatThrownBy(() -> new Length(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
