package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

  @Test
  void testGetResult() {
    Player player1 = new Player("p1");
    Player player2 = new Player("p2");
    Map<Player, String> resultByPlayer = Map.of(player1, "result1", player2, "result2");
    GameResult gameResult = new GameResult(resultByPlayer);

    String result = gameResult.getResult(player1);

    assertThat(result).isEqualTo("result1");
  }

  @Test
  void testGetResultWithNonExistentPlayer() {
    Player player1 = new Player("p1");
    Player player2 = new Player("p2");
    Map<Player, String> resultByPlayer = Map.of(player1, "result1", player2, "result2");
    GameResult gameResult = new GameResult(resultByPlayer);

    String result = gameResult.getResult(player2);

    assertThat(result).isEqualTo("result2");
  }

  @Test
  void testGetAllResults() {
    Player player1 = new Player("p1");
    Player player2 = new Player("p2");
    Map<Player, String> resultByPlayer = Map.of(player1, "result1", player2, "result2");
    GameResult gameResult = new GameResult(resultByPlayer);

    Map<Player, String> allResults = gameResult.getAllResults();

    assertThat(allResults).containsExactlyInAnyOrderEntriesOf(resultByPlayer);
  }
}