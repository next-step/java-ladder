package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonCountTest {

  @Test
  @DisplayName("사람 수를 입력받아 생성할 수 있다.")
  void create() {
    //given
    final int countOfPerson = 2;

    //when
    final PersonCount personCount = new PersonCount(countOfPerson);

    //then
    assertThat(personCount).isEqualTo(new PersonCount(countOfPerson));
  }

}
