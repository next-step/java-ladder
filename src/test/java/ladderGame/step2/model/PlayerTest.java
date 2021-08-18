package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

  @DisplayName("플레이어 생성.")
  @Test
  void createPlayerTest() {
    assertThat(new Player("user")).isEqualTo(new Player("user"));
  }

  @DisplayName("사용자 수 만큼의 이름을 받아 플래이어를 생성.")
  @Test
  void createPlayers() {

    assertThat(Players.createUser("user1,user2").size()).isEqualTo(2);
    assertThat(Players.createUser("user1,user2")).contains(new Player("user1"));
    assertThat(Players.createUser("user1,user2")).contains(new Player("user2"));
  }

  @DisplayName("중복되는 이름을 자동으로 제거하고 생성.")
  @Test
  void distinctDuplicateName() {
    assertThat(Players.createUser("user3,user3").size()).isEqualTo(1);
  }
}