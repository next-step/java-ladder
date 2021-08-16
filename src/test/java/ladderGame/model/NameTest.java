package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  void name() {
    assertThat(new Name("a")).isEqualTo(new Name("a"));
  }

  @DisplayName("입력된 사용자명 최대 5자 검증.")
  @Test
  void nameValidation() {
    assertThatThrownBy(
        ()->new Name("user12")
    ).isInstanceOf(IllegalArgumentException.class);
  }
}