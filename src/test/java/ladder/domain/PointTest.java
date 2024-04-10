package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
  @Test
  void 행의_첫_point_생성() {
    Point.first(0, false, sides -> Direction.RIGHT);
  }

  @Test
  void 다음_Point_생성() {
    Point point = Point.first(1, true, sides -> Direction.STRAIGHT);

    assertThat(point.next(false, sides -> Direction.STRAIGHT).move()).isEqualTo(Coordinates.of(1, 2));
  }

  @Test
  void 마지막_Point_생성() {
    Point point = Point.first(2, true, sides -> Direction.LEFT).last(sides -> Direction.RIGHT);
    assertThat(point.move()).isEqualTo(Coordinates.of(2, 3));
  }

  @ParameterizedTest
  @CsvSource(value = { "RIGHT,2, 2", "LEFT, 0, 2", "STRAIGHT, 1, 2"})
  void 이동(Direction direction, Integer x, Integer y) {
    Point point = Point.first(1, true, sides -> direction).next(false, sides -> direction);
    assertThat(point.move()).isEqualTo(Coordinates.of(x, y));
  }
}
