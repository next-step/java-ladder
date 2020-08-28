package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

  @Test
  void mapToPlayer() {
    List<Player> players = LadderGame.mapToPlayers(Arrays.asList("one", "two", "three"));

    assertThat(players).isEqualTo(
            Arrays.asList(new Player("one", 0),
                    new Player("two", 1),
                    new Player("three", 2))
    );
  }
}