package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import nextstep.ladder.exception.EmptyStringNotAllowedException;
import nextstep.ladder.exception.OverResultLengthLimitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  @Test
  @DisplayName("결과를 입력받아 생성할 수 있다.")
  void create() {
    //given
    final String resultSource = "꽝";

    //when
    final Result result = new Result(resultSource);

    //then
    assertThat(result).isEqualTo(new Result(resultSource));
  }

  @Test
  @DisplayName("결과는 1자 이상 5자 이하여야 한다.")
  void createFail() {
    //given
    final String emptyString = "";
    final String overSizeString = "abcdef";

    //when
    //then
    assertAll(
        () -> assertThatThrownBy(() -> new Result(emptyString))
            .isInstanceOf(EmptyStringNotAllowedException.class)
            .hasMessage(EmptyStringNotAllowedException.EMPTY_STRING_NOT_ALLOWED),
        () -> assertThatThrownBy(() -> new Result(overSizeString))
            .isInstanceOf(OverResultLengthLimitException.class)
            .hasMessage(OverResultLengthLimitException.OVER_RESULT_LENGTH_LIMIT)
    );
  }
}
