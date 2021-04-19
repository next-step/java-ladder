package ladder.model.result;

import ladder.model.member.Players;
import ladder.model.prize.Prizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InterimResultsTest {
  private int size;
  private InterimResults interimResults;

  @BeforeEach
  void setup() {
    size = 3;
    interimResults = InterimResults.makeInterimResults(size);
  }

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    Assertions.assertThat(interimResults.interimResults.size()).isEqualTo(size);
  }

  @Test
  @DisplayName("래더 종합 점수 변경 테스트")
  void makeLadderTotalResultTest() {
    String playerName = "꽉,깡,망";
    String prizeName = "꽝,3000,3000";

    Players players = Players.initNames(playerName);
    Prizes prizes = Prizes.makePrizes(prizeName, players.size());

    Assertions.assertThat(interimResults.toLadderTotalResult(players, prizes).results().size()).isEqualTo(size);
  }

}
