package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

  @Test
  @DisplayName("[Players] 입력 받은 참가자 이름으로 Players 일급 컬렉션 생성 테스트")
  void createPlayersTest() {
    String inputNames = "pobi,honux,crong,jk";
    Players players = new Players(NameStore.createPlayers(inputNames));

    assertThat(players.names().size()).isEqualTo(4);
  }
}
