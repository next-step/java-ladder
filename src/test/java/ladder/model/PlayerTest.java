package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {

  @Test
  void ride() {
    Player player = new Player("kim", 0);
    
    assertThat(player.ride(Direction.RIGHT)).isEqualTo(new Position(1));
    assertThat(player.ride(Direction.RIGHT)).isEqualTo(new Position(2));
  }
}
