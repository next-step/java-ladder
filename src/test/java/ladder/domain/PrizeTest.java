package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
  @ParameterizedTest
  @ValueSource(strings = { "꽝", "3000", "0", })
  void 경품_객체_정상_생성(String input) {
    new Prize(input);
  }

  @ParameterizedTest
  @CsvSource(
          value = {
                  "광,유효하지 않은 입력입니다.(숫자가 아닌 값)",
                  "-3000,잘못된 경품 입력입니다.(0보다 작은 값)",
                  ",잘못된 경품 입력입니다.(공백)",
                  "null,잘못된 경품 입력입니다.(공백)"
          },
          nullValues = {"null"}
  )
  void 경품_객체_생성_예외(String input, String message) {

    Assertions.assertThatThrownBy(() -> new Prize(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
  }
}
