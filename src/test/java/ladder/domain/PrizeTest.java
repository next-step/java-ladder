package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
  @ParameterizedTest
  @ValueSource(strings = { "꽝", "3000", "1" })
  void 경품_객체_정상_생성(String input) {
    new Prize(input);
  }

  @ParameterizedTest
  @CsvSource(
          value = {
                  "광,잘못된 경품 입력입니다.",
                  "-3000,잘못된 경품 입력입니다.",
                  "'',잘못된 경품 입력입니다.",
                  "null,잘못된 경품 입력입니다.",
                  "0030,잘못된 경품 입력입니다.",
                  "0,잘못된 경품 입력입니다.",
                  "123ABC,잘못된 경품 입력입니다."
          },
          nullValues = {"null"}
  )
  void 경품_객체_생성_예외(String input, String message) {
    Assertions.assertThatThrownBy(() -> new Prize(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
  }

  @ParameterizedTest
  @CsvSource( {"1000, 1000", "10000, 10000", "꽝, 꽝"})
  void 상품_값_반환(String input, String result) {
    Assertions.assertThat(new Prize(input).textValue()).isEqualTo(result);
  }
}
