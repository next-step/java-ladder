package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

  @Test
  void createNameTest() {
    assertThat(new Name("a")).isEqualTo(new Name("a"));
  }

  @DisplayName("입력된 사용자명 최대 5자 검증.")
  @ParameterizedTest
  @CsvSource(value = {"user12:user1","가나다라마바:가나다라마"},delimiter = ':')
  void nameLengthValidationTest(String wrongName, String fineName) {
    assertThatThrownBy(
        () -> new Name(wrongName)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사용자명은 최대 5글자까지 가능합니다.");

    assertThat(new Name(fineName)).isNotNull();
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