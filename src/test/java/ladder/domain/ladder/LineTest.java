package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.strategy.RandomPointGenerationStrategy;
import org.junit.jupiter.api.Test;

class LineTest {


  @Test
  void 하나의_row에_true가_연속해서_나오지_않음_검증() {
    Line line = Line.createLine(10, new RandomPointGenerationStrategy());

    List<Point> points = line.getPoints();

    for (int i = 0; i < points.size() - 1; i++) {
      assertThat(points.get(i).isContinuous(points.get(i + 1))).isFalse();
    }
  }


  @Test
  void 하나의_row에_true가_연속해지_나오는_경우_생성자를_통해_예외_검증() {
    assertThatThrownBy(() -> {
      Line line = new Line(Point.of(0, false, true), Point.of(1, true, true));
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void index_1번에서_오른쪽_사다리가_있는_경우_index_2번으로_이동_검증() {
    Point first = Point.of(0, false, false);
    Point second = Point.of(1, false, true);

    Line line = new Line(first, second);

    assertThat(line.move(1)).isEqualTo(2);
  }

  @Test
  void index_1번에서_왼쪽_사다리가_있는_경우_index_0번으로_이동_검증() {
    Point first = Point.of(0, false, true);
    Point second = Point.of(1, true, false);

    Line line = new Line(first, second);

    assertThat(line.move(1)).isEqualTo(0);
  }

  @Test
    void index_1번에서_사다리가_없는_경우_index_1번으로_이동_검증() {
    Point first = Point.of(0, false, false);
    Point second = Point.of(1, false, false);

    Line line = new Line(first, second);

    assertThat(line.move(1)).isEqualTo(1);
  }
}