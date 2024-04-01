package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
  @ParameterizedTest
  @ValueSource(strings = { "abcdef", "", })
  @NullSource
  void 이름_제한조건_어길_시_예외(String input) {
    Assertions.assertThatThrownBy(() -> Player.of(input))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = { "A", "AB", "ABC", "ABCD", "ABCDE" })
  void 정상_생성(String input) {
    Player.of(input);
  }
}
