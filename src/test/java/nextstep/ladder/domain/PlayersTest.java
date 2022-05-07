package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("중복된 이름이 있으면 예외를 던진다.")
  @Test
  void createWithSameName() {
    assertThatThrownBy(() -> Players.of(List.of("yeeun", "yeeun", "yeny")))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("List<String>을 인자로 받아 Players를 생성할 수 있다.")
  @Test
  void create() {
    Players players = Players.of(List.of("pobi", "honux", "crong", "jk"));
    Players expected = new Players(List.of(
        Player.of("pobi"), Player.of("honux"), Player.of("crong"), Player.of("jk")
    ));

    assertThat(players).isEqualTo(expected);
  }
}
