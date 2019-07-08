package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

  @Test
  void 생성테스트() {
    String inputName = "haha,hoho,hihi";
    assertThat(Players.of(inputName)).isEqualTo(Players.of(inputName));
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " "})
  void 공백_널은_이름에_올수없습니다(String name) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      Players.of(name);
    });
  }

  @Test
  void 이름분리테스트() {
    String inputName = "haha,hoho,hihi";
    Player player1 = new Player("haha");
    Player player2 = new Player("hoho");
    Player player3 = new Player("hihi");

    List<Player> players = Lists.list(player1, player2, player3);
    assertThat(Players.of(inputName).players()).isEqualTo(players);
  }

}
