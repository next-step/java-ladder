package ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

  private Player player;

  @BeforeEach
  void setUp() {
    String name = "kim";
    int position = 0;
    this.player = new Player(name, position);
  }

  @Test
  void ride() {
    assertThat(player.ride(Direction.RIGHT)).isEqualTo(new Position(1));
    assertThat(player.ride(Direction.RIGHT)).isEqualTo(new Position(2));
  }

  @Test
  void takeReward() {
    Reward rewardWithSamePosition = new Reward("3000", 0);
    assertThat(player.takeReward(rewardWithSamePosition)).isEqualTo(true);

    Reward rewardWithDifferentPosition = new Reward("4000", 2);
    assertThat(player.takeReward(rewardWithDifferentPosition)).isEqualTo(false);
  }
}
