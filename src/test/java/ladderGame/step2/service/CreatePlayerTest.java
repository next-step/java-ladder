package ladderGame.step2.service;

import static org.assertj.core.api.Assertions.assertThat;

import ladderGame.step2.model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreatePlayerTest {

  @DisplayName("사용자 수 만큼의 이름을 받아 플래이어를 생성.")
  @Test
  void createPlayers() {

    assertThat(CreatePlayer.createUser("user1,user2").size()).isEqualTo(2);
    assertThat(CreatePlayer.createUser("user1,user2")).contains(new Player("user1"));
    assertThat(CreatePlayer.createUser("user1,user2")).contains(new Player("user2"));
  }

  @DisplayName("중복되는 이름을 자동으로 제거하고 생성.")
  @Test
  void distinctDuplicateName() {
    assertThat(CreatePlayer.createUser("user3,user3").size()).isEqualTo(1);
  }
}