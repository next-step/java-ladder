package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("이름을 가지고 생성할 수 있다.")
  void create() {
    //given
    final String name = "pobi";

    //when
    final Person pobi = new Person(name);

    //then
    assertAll(
        () -> assertThat(pobi).isEqualTo(new Person(name)),
        () -> assertThat(pobi.getName()).isEqualTo(name)
    );
  }
}
