package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  @DisplayName("이름을 받아서 이름을 생성할 수 있다.")
  void create() {
    //given
    final String nameSource = "dion";

    //when
    final Name name = new Name(nameSource);

    //then
    assertThat(name).isEqualTo(new Name(nameSource));
  }
}
