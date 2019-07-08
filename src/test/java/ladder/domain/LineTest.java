package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

  @Test
  void move() {
    Point first = Point.first(false);
    List<Point> points = Arrays.asList(first, first.next(true), first.next(true).next(false));
    Line line = Line.of(points);
    assertThat(line.move(0)).isEqualTo(0);
    assertThat(line.move(1)).isEqualTo(2);
    assertThat(line.move(2)).isEqualTo(1);
  }
}
