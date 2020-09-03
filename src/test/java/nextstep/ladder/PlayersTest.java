package nextstep.ladder;

import nextstep.ladder.biz.Chessmen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

  private Players players;
  private List<Player> playerList;

  @BeforeEach
  void setUp() {
    playerList = Arrays.asList(new Player("name0", 0), new Player("name1", 1), new Player("name2", 2));
    players = new Players(playerList);
  }

  @Test
  void isEqual() {
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
            .isEqualTo(Arrays.asList(Chessmen.of(new Player("name0", 0)), Chessmen.of(new Player("name1", 1)), Chessmen.of(new Player("name2", 2))));
  }

  @Test
  void mapToPlayers() {
    assertThat(Players.mapToPlayers(Arrays.asList("name0", "name1", "name2")))
            .isEqualTo(new Players(playerList));
  }
}