package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

  @Test
  public void first() {
    assertThat(Point.first(true).move()).isEqualTo(1);
    assertThat(Point.first(false).move()).isEqualTo(0);
  }

  @Test
  public void next_stay() {
    Point second = Point.first(false).next(false);
    assertThat(second.move()).isEqualTo(1);
  }

  @Test
  public void next_left() {
    Point second = Point.first(true).next(false);
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  public void next_right() {
    Point second = Point.first(false).next(true);
    assertThat(second.move()).isEqualTo(2);
  }

  @Test
  public void next() {
    Point second = Point.first(true).next();
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  void last() {
    Point last = Point.first(true).last();
    assertThat(last.move()).isEqualTo(0);
  }
}
