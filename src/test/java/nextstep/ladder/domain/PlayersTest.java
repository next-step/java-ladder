package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

  @Test
  @DisplayName("입력된 플레이어 이름들을 ,(콤마) 구분하여 플레이어 생성")
  void givenPlayerNames_ShouldBeCreated() {
    final String playerNames = "apple,tesla,tsmc,meta";
    assertThat(Players.create(playerNames)).isEqualTo(Players.create(playerNames));
  }
}
