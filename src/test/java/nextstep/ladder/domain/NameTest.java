package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

  @DisplayName("생성 시, 이름이 5자보다 길면 예외를 던진다")
  void createWithLongName() {
    assertThatThrownBy(() -> new Name("가나다라마바")).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("생성 시, 이름에 null이나 빈 스트링이 들어오면 예외를 던진다.")
  @ParameterizedTest
  @NullAndEmptySource
  void createWithNullOrEmptyName(String value) {
    assertThatThrownBy(() -> new Name(value)).isInstanceOf(IllegalArgumentException.class);
  }
}
