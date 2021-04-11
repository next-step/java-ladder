package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.OverNameLengthLimitException;
import nextstep.ladder.exception.PersonCountTooLowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

  @Test
  @DisplayName("이름 배열을 받아서 People을 생성한다.")
  void createWithStringArray() {
    //given
    final String[] names = new String[]{"pobi", "crong", "honux", "jk"};

    //when
    final People people = People.from(names);

    //then
    assertAll(
        () -> assertThat(people).isEqualTo(People.from(names)),
        () -> assertThat(new PersonCount(people.personList().size())).isEqualTo(new PersonCount(names.length))
    );
  }

  @Test
  @DisplayName("이름의 길이가 긴 항목이 있는경우 생성에 실패한다.")
  void createFailWhenOverNameLengthLimit() {
    //given
    final String[] names = new String[]{"pobi", "crong", "honux", "jk", "0123456"};

    //when
    //then
    assertThatThrownBy(() -> People.from(names))
        .isInstanceOf(OverNameLengthLimitException.class)
        .hasMessage(OverNameLengthLimitException.OVER_NAME_LENGTH_LIMIT);
  }

  @Test
  @DisplayName("인원이 2명 이하인 경우 생성에 실패한다.")
  void createFailWhenUnderPersonLimit() {
    //given
    final String[] names = new String[]{"pobi"};

    //when
    //then
    assertThatThrownBy(() -> People.from(names))
        .isInstanceOf(PersonCountTooLowException.class)
        .hasMessage(PersonCountTooLowException.PERSON_COUNT_TOO_LOW);
  }
}
