package nextstep.ladder;

import nextstep.ladder.domain.Player;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {
  @Test
  void testCreatePlayer() {
    String playerName = "pobi";

    Player player = new Player(playerName);

    AssertionsForClassTypes.assertThat(player).isEqualTo(new Player(playerName));
  }

  @Test
  void testCreatePlayerWithLongerThan5LetterName() {
    String playerName = "pobi123";

    assertThatThrownBy(() -> new Player(playerName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 5자 이하여야 합니다.");
  }
}