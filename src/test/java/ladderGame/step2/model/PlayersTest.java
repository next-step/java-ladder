package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("사용자명을 쉼표단위로 여러개 입력하여 사용자를 생성.")
  @Test
  void createPlayersTest() {
    Players players = new Players(Players.createUser("user1,user2"));
    assertThat(players.count()).isEqualTo(2);
  }
}