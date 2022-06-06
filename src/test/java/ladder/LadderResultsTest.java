package ladder;

import static ladder.NameTest.PLAYER_NAME_LIST_1;
import static ladder.PlayersTest.PLAYERS_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

  private Name player;
  private Prize prize;
  private Map<Name, Prize> results;
  private LadderResults ladderResults;


  @BeforeEach
  void setup() {
    player = new Name("참가자1");
    prize = new Prize("상1");
    results = new HashMap<>();
    ladderResults = new LadderResults(results);
    ladderResults.put(player, prize);
  }

  @Test
  void LadderResults_생성() {
    assertDoesNotThrow(() -> new LadderResults(results));
  }

  @Test
  void put_성공() {
    Map<Name, Prize> expectedMap = new HashMap<>();
    expectedMap.put(player, prize);
    expectedMap.put(new Name("참가자2"), new Prize("상2"));
    LadderResults expected = new LadderResults(expectedMap);
    ladderResults.put(new Name("참가자2"), new Prize("상2"));

    assertThat(ladderResults).isEqualTo(expected);
  }

  @Test
  void prizeOf_성공() {
    assertThat(ladderResults.prizeOf(player)).isEqualTo(prize);
  }

  @Test
  void allPlayersAndResults() {
    Set<Entry<Name, Prize>> expected = results.entrySet();

    assertThat(ladderResults.allPlayersAndResults()).isEqualTo(expected);
  }

  @Test
  void init_성공() {
    Map<Name, Prize> map = new HashMap<>();
    for (Name player : PLAYER_NAME_LIST_1) {
      map.put(player, new Prize("꽝"));
    }
    LadderResults expected = new LadderResults(map);


    assertThat(LadderResults.init(PLAYERS_1)).isEqualTo(expected);
  }
}
