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
  void makeWayNotDuplicated(boolean input, boolean result) {
    Point prevPoint = new Point(input);
    Point point = new Point();

    Point nowPoint = point.makeWay(prevPoint, () -> true);
    assertEquals(result, nowPoint.hasWay());
  }

}