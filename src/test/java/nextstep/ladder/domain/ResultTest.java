package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

  @Test
  @DisplayName("실행결과 생성")
  void createResult() {
    assertThat(new Result("꽝")).isEqualTo(new Result("꽝"));
  }

  @DisplayName("실행결과가 없거나 공백 예외 처리")
  @ParameterizedTest
  @ValueSource(strings = {"", " "})
  void createResult_ShouldBeException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Result(input));
  }

}
