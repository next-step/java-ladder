package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  void createPersonLine() {
    Line points = new Line(3);

    assertThat(points.pointOfCount())
        .isEqualTo(2);
  }

  @Test
  void pointsOfLine() {
    Line points = new Line(3);

    assertThat(points.getLine())
        .isIn(Arrays.asList(Arrays.asList(Point.of(true), Point.of(false)),
                Arrays.asList(Point.of(false), Point.of(true))));
  }
}
