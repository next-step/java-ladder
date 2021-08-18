package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("사용자명을 쉼표단위로 여러개 입력하여 사용자를 생성.")
  @Test
  void createPlayersTest() {
    Players players = new Players(Players.createUser("user1,user2"));
    assertThat(players.count()).isEqualTo(2);
  }

  @DisplayName("생성된 사용자수가 0을 초과하는지 검증하는 테스트.")
  @Test
  void validationPlayersCount() {
    assertThatThrownBy(
        ()->new Players(Players.createUser(",,,"))
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Players.MSG_ERROR_LIMIT_PLAYERS);
  }
}