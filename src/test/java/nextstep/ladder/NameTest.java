package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.OverNameLengthLimitException;
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
    assertAll(
        () -> assertThat(name).isEqualTo(new Name(nameSource)),
        () -> assertThat(name.getName()).isEqualTo(nameSource)
    );
  }

  @Test
  @DisplayName("이름의 최대 자릿수를 초과할 수 없다.")
  void createFailWhenOverNameLengthLimit() {
    assertThatThrownBy(() -> new Name("123456"))
        .isInstanceOf(OverNameLengthLimitException.class)
        .hasMessage(OverNameLengthLimitException.OVER_NAME_LENGTH_LIMIT);
  }
}
