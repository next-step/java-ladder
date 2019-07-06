package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

  @Test
  void test_startGame() {

    Rewards rewards = makeMockRewards();
    Players players = makeMockPlayers();
    Ladder ladder = makeMockLadder();

    LadderGame.start(ladder, players);

    Result result = LadderGame.makeResult(players, rewards);

    assertThat(result.get("kim")).isEqualTo("3000");
    assertThat(result.get("lee")).isEqualTo("4000");
  }

  private Ladder makeMockLadder() {
    Layer layer1 = new Layer(Arrays.asList(false, true, false));
    Layer layer2 = new Layer(Arrays.asList(false, false, true));
    Layer layer3 = new Layer(Arrays.asList(false, true, false));

    Ladder ladder = new Ladder(Arrays.asList(layer1, layer2, layer3));
    return ladder;
  }

  private Players makeMockPlayers() {
    List<String> names = Arrays.asList("kim", "lee", "park", "low");
    return Players.of(names);
  }

  private Rewards makeMockRewards() {
    List<String> rewards = Arrays.asList("3000", "꽝", "2000", "4000");
    return Rewards.of(rewards);
  }
}
