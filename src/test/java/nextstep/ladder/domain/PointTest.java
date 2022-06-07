package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void first() {
    assertThat(Point.first(true).move()).isEqualTo(1);
    assertThat(Point.first(false).move()).isZero();
  }

  @Test
  void next_not_move() {
    Point second = Point.first(false).next(false);
    assertThat(second.move()).isEqualTo(1);
  }

  @Test
  void next_left() {
    Point second = Point.first(true).next(false);
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  void next_right() {
    Point second = Point.first(false).next(true);
    assertThat(second.move()).isEqualTo(2);
  }

  @Test
  void next() {
    Point second = Point.first(true).next();
    assertThat(second.move()).isEqualTo(0);
  }
}
