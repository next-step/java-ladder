package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

public class DefaultLadderTest {

  @Test
  void moveTest() {
    Point point = Point.of(0, Direction.RIGHT);
    Point point1 = Point.of(1, Direction.LEFT);
    Point point2 = Point.of(2, Direction.RIGHT);
    Point point3 = Point.of(3, Direction.LEFT);
    List<Point> points = Lists.list(point, point1, point2, point3);

    LadderLine ladderLine1 = LadderLine.of(points);
    LadderLine ladderLine2 = LadderLine.of(points);
    LadderLine ladderLine3 = LadderLine.of(points);

    List<LadderLine> ladderLines = Lists.list(ladderLine1, ladderLine2, ladderLine3);
    DefaultLadder defaultLadder = DefaultLadder.of(ladderLines, 5);
    System.out.println(defaultLadder.toString());

    assertThat(defaultLadder.move(0)).isEqualTo(1);
    assertThat(defaultLadder.move(1)).isEqualTo(0);
    assertThat(defaultLadder.move(2)).isEqualTo(3);
    assertThat(defaultLadder.move(3)).isEqualTo(2);
  }

}
