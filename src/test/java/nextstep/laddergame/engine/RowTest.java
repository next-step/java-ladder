package nextstep.laddergame.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    List<Point> points = make3Point();
    assertThatThrownBy(() -> new Row(points)).isInstanceOf(IllegalArgumentException.class);
  }

  private List<Point> make3Point() {
    List<Point> points = new ArrayList<>();
    Point point1 = new Point();
    point1.createLineWithRightPoint();

    Point point2 = new Point(); // Line을 양방향으로 가지고 있음.
    point2.createLineWithLeftPoint();
    point2.createLineWithRightPoint();

    Point point3 = new Point();
    point3.createLineWithLeftPoint();
    return points;
  }

  @DisplayName("Line이 겹치도록 Row가 생성된다면 Exception을 던진다.")
  @Test
  public void createRow_throwException_ifTwoWayPoint() {
    assertThatThrownBy(() -> Row.createRow(5, (p1, p2) -> true))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("넓이가 1미만인 Row는 생성할 수 없다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1, -2, -10})
  public void createRow_throwException_ifLessThan1(int input) {
    assertThatThrownBy(() -> Row.createRow(input, (p1, p2) -> false))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("넓이만큼의 Point수를 갖는 Row를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 10})
  public void createRow(int input) {
    Row row = Row.createRow(input, (p1, p2) -> false);

    assertThat(row.getPoints().size()).isEqualTo(input);
  }
}
