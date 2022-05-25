package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

  @Test
  @DisplayName("플레이어 생성")
  void createPlayer() {
    assertThat(new Player("apple")).isEqualTo(new Player("apple"));
  }

  @DisplayName("플레이어 이름이 없거나 공백 및 최대 5글자 이상 예외 처리")
  @ParameterizedTest
  @ValueSource(strings = {"", " ", "netflix"})
  void givenFiveLength_ShouldBeException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Player(input));
  }

}