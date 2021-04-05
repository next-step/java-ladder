package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("사람의 이름을 가지고 생성할 수 있다.")
  void create() {
    //given
    final String name = "pobi";

    //when
    Person pobi = new Person(name);

    //then
    assertThat(pobi).isEqualTo(new Person(name));
  }
}
