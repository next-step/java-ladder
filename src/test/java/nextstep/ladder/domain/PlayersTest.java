package nextstep.ladder.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

public class PlayersTest {

  @Test
  void testCreatePlayers() {
    String players = "pobi, crong, jk";

    Players playersList = new Players(players);

    AssertionsForClassTypes.assertThat(playersList.size()).isEqualTo(3);
    AssertionsForClassTypes.assertThat(playersList.toConsoleOutput()).isEqualTo(" pobi crong    jk");
  }

  @Test
  void testCreatePlayersWithLessThan2Players() {
    String players = "pobi";

    AssertionsForClassTypes.assertThatThrownBy(() -> new Players(players))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여자는 2명 이상이어야 합니다.");
  }
}