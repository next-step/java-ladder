package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  public void first() {
    assertEquals(Point.first(() -> true).move(), 1);
    assertEquals(Point.first(() -> false).move(), 0);
  }

  @Test
  public void next_stay() {
    Point second = Point.first(() -> false).next(() -> false);
    assertEquals(second.move(), 1);
  }

  @Test
  public void next_left() {
    Point second = Point.first(() -> true).next(() -> false);
    assertEquals(second.move(), 0);
  }

  @Test
  public void next_right() {
    Point second = Point.first(() -> false).next(() -> true);
    assertEquals(second.move(), 2);
  }

  @Test
  public void next() {
    Point second = Point.first(() -> true).next(() -> false);
    assertEquals(second.move(), 0);
  }

}