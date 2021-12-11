package nextstep.ladder;

import nextstep.ladder.domain.entity.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

  @ParameterizedTest
  @ValueSource(strings = {"kevin", "poo", "bar"})
  @DisplayName("5자 이하의 문자열로 이름을 주어 name class를 생성한다.")
  void create(String inputName) {
    Name name = new Name(inputName);
    assertEquals(inputName, name.tellName());
  }

  @ParameterizedTest
  @ValueSource(strings = {"kevinnnn", "pooooo", "barrrr"})
  @DisplayName("5자 이상의 문자열을 입력하면 exception을 던진다.")
  void createMoreThan5(String inputName) {
    assertThrows(IllegalArgumentException.class, () -> new Name(inputName));
  }

}
