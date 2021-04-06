package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.OverNameLengthLimitException;
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
        () -> assertThat(pobi.personName()).isEqualTo(name)
    );
  }

  @Test
  @DisplayName("이름 객체를 가지고 생성할 수 있다.")
  void createWithName() {
    //given
    final Name name = new Name("pobi");

    //when
    final Person pobi = new Person(name);

    //then
    assertAll(
        () -> assertThat(pobi).isEqualTo(new Person(name)),
        () -> assertThat(pobi.getName()).isEqualTo(name)
    );
  }

  @Test
  @DisplayName("이름의 최대 글자를 초과한 경우 생성에 실패한다.")
  void createFailWhenOverNameLengthLimit() {
    assertThatThrownBy(() -> new Person("123456"))
        .isInstanceOf(OverNameLengthLimitException.class)
        .hasMessage(OverNameLengthLimitException.OVER_NAME_LENGTH_LIMIT);
  }
}
