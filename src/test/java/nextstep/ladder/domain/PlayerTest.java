package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {
  @Test
  void testCreatePlayer() {
    String playerName = "pobi";

    Player player = new Player(playerName);

    assertThat(player).isEqualTo(new Player(playerName));
  }

  @Test
  void testCreatePlayerWithLongerThan5LetterName() {
    String playerName = "pobi123";

    assertThatThrownBy(() -> new Player(playerName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(String.format("이름은 %d자 이하여야 합니다.", Player.MAX_NAME_LENGTH));
  }

  @Test
  void testPlay() {
    String playerName = "pobi";
    Player player = new Player(playerName);
    Ladder ladder = new Ladder(3, new Players("pobi, crong, jk"), () -> true, "0, 1, 2");

    String result = player.play(ladder, 0);

    assertThat(result).isEqualTo("1");
  }
}