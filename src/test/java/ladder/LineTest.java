package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  public void 생성테스트() {
    int playersCount = 5;
    Line line = new Line(playersCount);
  }

  @Test
  public void moveTest() {
    Point straightPoint = new Point(Direction.STRAIGHT);
    Point rightPoint = new Point(Direction.RIGHT);
    Point leftPoint = new Point(Direction.LEFT);

    List<Point> pointsParam = Arrays.asList(straightPoint, rightPoint, leftPoint);
    Points points = new Points(pointsParam);

    Line line = new Line(points);

    //  |     |-----|
    assertThat(line.move(0)).isEqualTo(0);
    assertThat(line.move(1)).isEqualTo(2);
    assertThat(line.move(2)).isEqualTo(1);
  }

}
