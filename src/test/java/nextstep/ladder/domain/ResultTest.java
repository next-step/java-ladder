package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
