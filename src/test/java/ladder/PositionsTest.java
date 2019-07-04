package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionsTest {

  @Test
  public void 생성테스트() {
    int playerCount = 5;
    Positions positions = new Positions(playerCount);
    assertThat(positions.count()).isEqualTo(playerCount-1);
  }

}