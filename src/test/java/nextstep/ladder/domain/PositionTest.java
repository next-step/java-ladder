package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  @DisplayName("오른쪽 방향 이동")
  void moveRight() {
    Position position = Position.of(0, Point.of(false, true));
    assertThat(position.move()).isEqualTo(1);
  }

  @Test
  @DisplayName("왼쪽 방향 이동")
  void moveLeft() {
    Position position = Position.of(1, Point.of(true, false));
    assertThat(position.move()).isEqualTo(0);
  }

  @Test
  @DisplayName("멈춤")
  void stop() {
    Position position = Position.of(1, Point.of(false, false));
    assertThat(position.move()).isEqualTo(1);
  }
}