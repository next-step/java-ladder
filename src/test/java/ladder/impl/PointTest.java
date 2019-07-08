package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  void 첫번째_point_생성테스트() {
    Point point = Point.first();
    assertThat(point.position()).isEqualTo(new Position(0));
    assertThat(point.direction()).isIn(Direction.RIGHT, Direction.STRAIGHT);
  }

  @Test
  void next_point_생성테스트() {
    Point point = Point.first().next();
    assertThat(point.position()).isEqualTo(new Position(1));
  }

  @Test
  void last_point() {
    Point point = Point.first().last(2);
    assertThat(point.direction()).isIn(Direction.LEFT, Direction.STRAIGHT);
  }

  @Test
  void rightMoveTest() {
    Point point = Point.of(0, Direction.RIGHT);
    assertThat(point.move()).isEqualTo(new Position(1));
  }

  @Test
  void leftMoveTest2() {
    Point point = Point.of(1, Direction.LEFT);
    assertThat(point.move()).isEqualTo(new Position(0));
  }

  @Test
  void straightMoveTest3() {
    Point point = Point.of(0, Direction.STRAIGHT);
    assertThat(point.move()).isEqualTo(new Position(0));
  }

}
