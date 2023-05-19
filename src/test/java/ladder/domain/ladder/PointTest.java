package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import ladder.domain.strategy.NextPointGenerationStrategy;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void 첫번째_Point_생성시_값_검증() {
    NextPointGenerationStrategy strategy = (prev) -> false;

    Point firstPoint = Point.first(strategy);

    assertThat(firstPoint).isEqualTo(Point.of(0, false, false));
  }

  @Test
  void 다음_index의_point_생성시_값_검증() {

    Point prevPoint = Point.of(0, false, false);

    NextPointGenerationStrategy strategy = (prev) -> false;
    Point nextPoint = prevPoint.next(strategy);

    assertThat(nextPoint).isEqualTo(Point.of(1, false, false));
  }

  @Test
  void 마지막_point_current_값_false_검증() {
    Point beforeLastPoint = Point.of(3, false, true);
    Point lastPoint = beforeLastPoint.last();

    assertThat(lastPoint).isEqualTo(Point.of(4, true, false));
  }

  @Test
  void point가_왼쪽으로_이동하는_경우_검증() {
    Point point = Point.of(1, true, false);
    assertThat(point.move()).isEqualTo(0);
  }

  @Test
  void point가_오른쪽으로_이동하는_경우_검증() {
    Point point = Point.of(1, false, true);
    assertThat(point.move()).isEqualTo(2);
  }

  @Test
  void point가_이동하지_않는_경우_검증() {
    Point point = Point.of(1, false, false);
    assertThat(point.move()).isEqualTo(1);
  }


}