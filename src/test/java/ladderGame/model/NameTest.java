package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  void createNameTest() {
    assertThat(new Name("a")).isEqualTo(new Name("a"));
  }

  @DisplayName("입력된 사용자명 최대 5자 검증.")
  @Test
  void nameLengthValidationTest() {
    assertThatThrownBy(
        () -> new Name("user12")
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사용자명은 최대 5글자까지 가능합니다.");

    assertThatThrownBy(
        () -> new Name("가나다라마바")
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사용자명은 최대 5글자까지 가능합니다.");

    assertThat(new Name("abcde")).isNotNull();
  }

  @DisplayName("입력된 사용자명 빈값 검증.")
  @Test
  void nameEmptyValidationTest() {
    assertThatThrownBy(
        () -> new Name("")
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사용자이름을 입력 해주세요.");
  }
}