package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RowTest {

  @DisplayName("사다리 넓이(Point 갯수)가 1보다 작으면 예외를 던진다.")
  @Test
  public void row_throwException_ifPointLess1() {
    List<Point> points = new ArrayList<>();
    assertThatThrownBy(() -> new Row(points)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Point가 Line을 2방향 전부 가지고 있으면 예외를 던진다.")
  @Test
  public void row_throwException_ifTwoWayLine() {
    List<Point> points = new ArrayList<>();
    Point point1 = new Point();
    point1.createLineWithRightPoint();
    Point point2 = new Point(); // Line을 양방향으로 가지고 있음.
    point2.createLineWithLeftPoint();
    point2.createLineWithRightPoint();
    Point point3 = new Point();
    point3.createLineWithLeftPoint();

    assertThatThrownBy(() -> new Row(points)).isInstanceOf(IllegalArgumentException.class);
  }

}
