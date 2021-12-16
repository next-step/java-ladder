package nextstep.ladder;

import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

  @ParameterizedTest
  @ValueSource(booleans = {true, false, false, true})
  @DisplayName("사다리에 boolean 값을 이용해 길을 놓는다.")
  void create(boolean value) {
    Point point = new Point(value);
    assertEquals(value, point.hasWay());
  }

  @ParameterizedTest
  @CsvSource(value = {"true:false", "false:true"}, delimiter = ':')
  @DisplayName("이전 사다리에 길이 있다면 길을 만들지않고, 이전 사다리에 길이 없다면 길을 만든다.")
  void createNextPoint(boolean input, boolean result) {
    Point prevPoint = new Point(input);

    Point nowPoint = prevPoint.next(result);
    assertEquals(result, nowPoint.hasWay());
  }

  @ParameterizedTest
  @CsvSource(value = {"true:false:-1", "false:true:1", "false:false:0"}, delimiter = ':')
  @DisplayName("길이 있는 쪽의 index를 반환한다.")
  void findDirection(boolean left, boolean right, int result) {
    Point leftPoint = new Point(left);
    Point rightPoint = new Point(right);

    int direction = rightPoint.findDirection(leftPoint);

    assertEquals(result, direction);
  }

}