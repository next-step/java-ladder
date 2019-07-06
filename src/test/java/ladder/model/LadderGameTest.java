package ladder.model;

import ladder.util.MockLadderGenerator;
import ladder.util.MockPlayersGenerator;
import ladder.util.MockRewardsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

  @Test
  void test_startGame() {

    Rewards rewards = MockRewardsGenerator.of("3000", "꽝", "2000", "4000");
    Players players = MockPlayersGenerator.of("kim", "lee", "sos", "loo");
    Ladder ladder = MockLadderGenerator.makeLadder();

    LadderGame.start(ladder, players);

    Result result = LadderGame.makeResult(players, rewards);

    assertThat(result.get("kim")).isEqualTo("3000");
    assertThat(result.get("lee")).isEqualTo("4000");
  }
}
