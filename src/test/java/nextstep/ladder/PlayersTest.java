package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

  @DisplayName("Test for constructor of Players")
  @Test
  public void testConstructor() {
    List<String> names = Arrays.asList("Aya", "Billo", "Clsan", "Lucas");

    List<Player> players = Players.withNames(names).getPlayers();

    assertThat(players.get(0).isAdjacent(players.get(1))).isTrue();
    assertThat(players.get(1).isAdjacent(players.get(0))).isTrue();
    assertThat(players.get(1).isAdjacent(players.get(2))).isTrue();
    assertThat(players.get(2).isAdjacent(players.get(1))).isTrue();
    assertThat(players.get(2).isAdjacent(players.get(3))).isTrue();
    assertThat(players.get(3).isAdjacent(players.get(2))).isTrue();
  }
}
