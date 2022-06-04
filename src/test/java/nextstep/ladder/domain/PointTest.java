package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  @DisplayName("오른쪽 방향 이동")
  void moveRight() {
    Point point = Point.of(false, true);
    assertThat(point.move()).isEqualTo(Direction.RIGHT);
  }

  @Test
  @DisplayName("왼쪽 방향 이동")
  void moveLeft() {
    Point point = Point.of(true, false);
    assertThat(point.move()).isEqualTo(Direction.LEFT);
  }

  @Test
  @DisplayName("멈춤")
  void stop() {
    Point point = Point.of(false, false);
    assertThat(point.move()).isEqualTo(Direction.STOP);
  }

  @Test
  @DisplayName("포인트 값이 겹치는 경우 예외발생")
  void exception() {
    assertThatIllegalArgumentException().isThrownBy(() -> Point.of(true, true));
  }
}