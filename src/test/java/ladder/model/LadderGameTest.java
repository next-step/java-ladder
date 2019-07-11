package ladder.model;

import ladder.util.MockLadderGenerator;
import ladder.util.MockPlayersGenerator;
import ladder.util.MockRewardsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

  private LadderGame game;
  private Players players;

  @BeforeEach
  void setUp() {
    players = MockPlayersGenerator.of("kim", "lee", "sos", "loo");
    Rewards rewards = MockRewardsGenerator.of("3000", "꽝", "2000", "4000");
    Ladder ladder = MockLadderGenerator.makeLadder();

    game = new LadderGame(ladder, players, rewards);
  }

  @Test
  @DisplayName("게임을 시작한 후 result에 모든 player의 게임 결과가 담기는지 확인한다.")
  void test_make_result_with_start_game() {
    Result result = game.start();
    assertThat(result.size()).isEqualTo(players.size());
  }

  @Test
  @DisplayName("Player들에게 상을 수여한다. return 값은 상을 수여한 Player 수와 같다.")
  void award() {
    assertThat(game.award()).isEqualTo(players.size());
  }
}
