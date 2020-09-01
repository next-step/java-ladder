package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

  private Players players;

  @BeforeEach
  void setUp() {
    players = new Players(Arrays.asList(new Player("name0", 0), new Player("name1", 1), new Player("name2", 2)));
  }

  @Test
  void create() {
    assertThat(players)
            .isEqualTo(new Players(Arrays.asList(new Player("name0", 0), new Player("name1", 1), new Player("name2", 2))));
  }

  @Test
  void nameAsList() {
    assertThat(players.nameAsList())
            .isEqualTo(Arrays.asList("name0", "name1", "name2"));
  }

  @Test
  void chessmenAsList() {
    assertThat(players.chessmenAsList())
            .isEqualTo(Arrays.asList(Chessmen.location(0), Chessmen.location(1), Chessmen.location(2)));
  }
}