package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import ladderGame.service.CreatePlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("플래이어수와 사다리높이를 입력해서 사다리 생성.")
  @Test
  void createPlayers() {
    Players players = new Players(CreatePlayer.createUser("user1,user2"));
    assertThat(players.findPlayersCount()).isEqualTo(2);
  }
}