package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @Test
  @DisplayName("플레이어 생성")
  void createPlayer() {
    assertThat(new Player("apple")).isEqualTo(new Player("apple"));
  }

  @Test
  @DisplayName("플레이어 이름 최대 5글자 이상 예외 처리")
  void givenFiveLength_ShouldBeException() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Player("netflix"));
  }
}