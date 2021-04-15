package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

  @Test
  @DisplayName("입력한 문자열에 맞게 사용자들을 생성한다. 사용자 구분은 \",\"로 구분한다.")
  void create() {
    // given
    String actual = "gmoon, dodo, dolgi";

    // when
    Players players = Players.create(actual);

    // then
    assertThat(players.getValues())
            .isNotEmpty()
            .hasSize(3)
            .contains(Player.create("gmoon"),
                    Player.create("dodo"),
                    Player.create("dolgi"));
  }
}