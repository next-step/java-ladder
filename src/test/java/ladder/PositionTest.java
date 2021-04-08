package ladder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  @DisplayName("rightMove 확인")
  public void rightMove() {
    Position position = new Position(0);
    assertThat(position.rightMove()).isEqualTo(new Position(1));
  }

  @Test
  @DisplayName("leftMove 확인")
  public void leftMove() {
    Position position = new Position(1);
    assertThat(position.leftMove()).isEqualTo(new Position(0));
  }

}
