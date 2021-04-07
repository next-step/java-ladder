package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.PersonCountTooLowException;
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

  @Test
  @DisplayName("사다리 게임을 진행하기 위한 최소한의 인원은 2명이다.")
  void createFailWhenUnderTwoPersonCount() {
    assertAll(
        () -> assertThatThrownBy(() -> new PersonCount(0))
            .isInstanceOf(PersonCountTooLowException.class)
            .hasMessage(PersonCountTooLowException.PERSON_COUNT_TOO_LOW),
        () -> assertThatThrownBy(() -> new PersonCount(1))
            .isInstanceOf(PersonCountTooLowException.class)
            .hasMessage(PersonCountTooLowException.PERSON_COUNT_TOO_LOW)
    );
  }
}
