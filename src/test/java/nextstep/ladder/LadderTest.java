package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @DisplayName("Test for ride method")
  @Test
  public void testRide() {
    int height = 5;
    int width = 4;
    Ladder ladder = new Ladder(height, width);
    Player aya = new Player("aya", 0);

    assertThat(ladder.ride(aya).getName().equals(aya.getName())).isTrue();
  }
}
