package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {

  @Test
  void test_makePlayers() {
    List<String> names = Arrays.asList("kim", "park", "lee");
    Players players = Players.of(names);

    assertThat(players.size()).isEqualTo(3);
  }
}
