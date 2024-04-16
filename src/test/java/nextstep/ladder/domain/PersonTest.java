package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  @DisplayName("사람을 생성한다.")
  void createPerson() {
    assertThatNoException().isThrownBy(() -> new Person("pobi"));
  }

  @Test
  @DisplayName("사람의 이름은 5자를 넘을 수 없다.")
  void createPersonException() {
    assertThatThrownBy(() ->  new Person("pobime")).isInstanceOf(IllegalArgumentException.class);
  }
}
