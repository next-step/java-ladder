package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PointsTest {

  @Test
  public void 생성테스트() {
    int playerCount = 5;
    Points points = new Points(playerCount);
    assertThat(points.count()).isEqualTo(playerCount);
  }

  @Test
  public void moveTest() {
    Point straightPoint = new Point(Direction.STRAIGHT);
    Point rightPoint = new Point(Direction.RIGHT);
    Point leftPoint = new Point(Direction.LEFT);

    List<Point> pointsParam = Arrays.asList(straightPoint, rightPoint, leftPoint);
    Points points = new Points(pointsParam);

    //  |     |-----|
    assertThat(points.move(0)).isEqualTo(0);
    assertThat(points.move(1)).isEqualTo(2);
    assertThat(points.move(2)).isEqualTo(1);
  }

}