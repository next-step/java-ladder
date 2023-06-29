package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

  @Test
  void validate_pass() {
    new PlayerName("soko");
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "hyeonsu"})
  void validate_fail(String input) {
    assertThatThrownBy(() -> new PlayerName(input))
        .isInstanceOf(IllegalArgumentException.class)
        // PlayerName에 있는 상수를 외부로 노출시키고 싶지 않음 + 어차피 변경되면 테스트에서 걸러짐
        .hasMessageContaining("이름의 길이는 1 ~ 5글자 사이어야 합니다.");
  }
}