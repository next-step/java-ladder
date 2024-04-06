package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
  @ParameterizedTest
  @ValueSource(strings = { "abcdef", "" })
  void 유효하지_않은_이름_입력(String input) {
    assertThatThrownBy(() -> Name.of(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 이름");
  }

  @ParameterizedTest
  @ValueSource(strings = { "abcde", "A" })
  void 유효한_이름_입력(String input) {
    Name.of(input);
  }

  @Test
  void 캐싱() {
    assertThat(Name.of("abc") == Name.of("abc")).isTrue();
  }

  @Test
  void 이름_value_반환() {
    assertThat(Name.of("TEST").value()).isEqualTo("TEST");
  }
}
