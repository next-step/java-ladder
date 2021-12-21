package nextstep.ladder;

import nextstep.ladder.domain.entity.Direction;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

  @ParameterizedTest
  @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
  @DisplayName("첫번째 point의 길을 생성 또는 생성하지 않는다.")
  void first(boolean value, int direction) {
    Point point = Point.first(value);
    assertEquals(point.move(), direction);
  }

  @ParameterizedTest
  @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
  @DisplayName("이전 사다리에 길이 있다면 길을 만들지않고, 이전 사다리에 길이 없다면 길을 만든다.")
  void createNextPoint(boolean input, boolean result) {
    Point prevPoint = Point.first(input);

    Point nowPoint = prevPoint.next(result);
    assertEquals(result, nowPoint.hasRightWay());
  }

  @ParameterizedTest
  @CsvSource(value = {"true:false:-1", "false:true:1", "false:false:0"}, delimiter = ':')
  @DisplayName("길이 있는 쪽의 방향 부호를 반환한다.")
  void findDirection(boolean left, boolean right, int result) {
    Point point = new Point(0, Direction.of(left, right));
    assertEquals(result, point.move());
  }

}