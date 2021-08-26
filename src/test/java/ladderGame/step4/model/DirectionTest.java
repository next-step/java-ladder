package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

  @DisplayName("전진시 인덱스값 반환.")
  @Test
  void movementForwardPoint() {
    assertThat(Direction.FORWARD.getMovingPoint()).isEqualTo(1);
  }

  @DisplayName("후진시 인덱스값 반환.")
  @Test
  void movementBackPoint() {
    assertThat(Direction.BACK.getMovingPoint()).isEqualTo(-1);
  }

  @DisplayName("전진시 인덱스값 반환.")
  @Test
  void movementHoldPoint() {
    assertThat(Direction.HOLD.getMovingPoint()).isEqualTo(0);
  }
}