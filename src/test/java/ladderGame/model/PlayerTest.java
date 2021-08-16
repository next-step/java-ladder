package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @DisplayName("플레이어 생성.")
  @Test
  void createPlayerTest() {
    assertThat(new Player("user")).isEqualTo(new Player("user"));
  }

}