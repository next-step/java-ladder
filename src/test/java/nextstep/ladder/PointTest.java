package nextstep.ladder;

import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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

}