package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreatePlayerTest {

  @DisplayName("사용자 수 만큼의 이름을 받아 플래이어를 생성.")
  @Test
  void createPlayers() {

    assertThat(CreatePlayer.createUser("user1,user2").size()).isEqualTo(2);
    assertThat(CreatePlayer.createUser("user1,user2").get(0)).isEqualTo(new Player("user1"));
    assertThat(CreatePlayer.createUser("user1,user2").get(1)).isEqualTo(new Player("user2"));
  }
}