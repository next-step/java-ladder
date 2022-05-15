package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

  @DisplayName("생성자로 Players를 생성한다.")
  @Test
  void createByConstructor() {
    List<Player> playerList = List.of(
        Player.of("pobi"), Player.of("honux"), Player.of("crong"), Player.of("jk")
    );

    Players players = new Players(playerList);

    assertThat(players).isNotNull().isInstanceOf(Players.class);
  }

  @DisplayName("정적 팩터리 메서드로 Players를 생성한다.")
  @Test
  void createByFactoryMethod() {
    List<String> nameList = List.of("pobi", "honux", "crong", "jk");

    Players players = Players.of(nameList);

    assertThat(players).isNotNull().isInstanceOf(Players.class);
  }

  @DisplayName("중복된 이름이 있으면 예외를 던진다.")
  @Test
  void createWithSameName() {
    assertThatThrownBy(() -> Players.of(List.of("yeeun", "yeeun", "yeny")))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("yeeun, yeeun, yeny");
  }

  @Test
  void getNames() {
    List<String> nameList = List.of("pobi", "honux", "crong", "jk");
    Players players = Players.of(nameList);

    List<String> playersNames = players.getNames();

    assertThat(playersNames).isEqualTo(nameList);
  }
}
