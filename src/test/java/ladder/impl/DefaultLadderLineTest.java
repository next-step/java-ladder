package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

public class DefaultLadderLineTest {

  @Test
  public void 생성_테스트() {
    int countOfPlayer = 5;
    LadderLine ladderLine = LadderLine.of(countOfPlayer);
  }

  @Test
  public void moveTest() {
    Point point = Point.of(0, Direction.RIGHT);
    Point point1 = Point.of(1, Direction.LEFT);
    Point point2 = Point.of(2, Direction.RIGHT);
    Point point3 = Point.of(3, Direction.LEFT);
    List<Point> points = Lists.list(point, point1, point2, point3);

    LadderLine ladderLine = LadderLine.of(points);
    System.out.println(ladderLine.toString());

    assertThat(ladderLine.move(0)).isEqualTo(1);
    assertThat(ladderLine.move(1)).isEqualTo(0);
    assertThat(ladderLine.move(2)).isEqualTo(3);
    assertThat(ladderLine.move(3)).isEqualTo(2);
  }
}
