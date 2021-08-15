package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @DisplayName("플레이어 생성.")
  @Test
  void createPlayer() {
    assertThat(new Player("user")).isEqualTo(new Player("user"));
  }

  @DisplayName("입력된 사용자명 최대 5자 검증.")
  @Test
  void nameValidation() {
    assertThatThrownBy(
        ()->new Player("user12")
    ).isInstanceOf(IllegalArgumentException.class);
  }
}