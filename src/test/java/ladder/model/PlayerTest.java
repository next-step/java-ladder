package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

  @Test
  void ride() {
    Player player = new Player("kim", 0);

    player.ride(Direction.RIGHT);
    assertThat(player.getPosition()).isEqualTo(1);

    player.ride(Direction.LEFT);
    assertThat(player.getPosition()).isEqualTo(0);
  }
}
