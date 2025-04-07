package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {

  @DisplayName("사람 이름으로 객체 생성")
  @Test
  void create() {
    Person person = new Person("pobi");
    assertThat(person.getName()).isEqualTo("pobi");
  }

  @DisplayName("사람 이름은 최대 5글자까지만 허용")
  @ParameterizedTest
  @ValueSource(strings = {"abcdef", "가나다라마바"})
  void validateNameLength(String name) {
    assertThatThrownBy(() -> new Person(name))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름은 최대 5글자까지 가능합니다");
  }

  @DisplayName("사람 이름은 빈 문자열일 수 없음")
  @Test
  void validateEmptyName() {
    assertThatThrownBy(() -> new Person(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름은 빈 문자열일 수 없습니다");
  }
}
