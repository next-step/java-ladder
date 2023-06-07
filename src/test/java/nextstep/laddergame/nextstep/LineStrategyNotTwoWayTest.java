package nextstep.laddergame.nextstep;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.laddergame.engine.Point;
import nextstep.laddergame.nextstep.strategy.LineStrategyNotTwoWay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineStrategyNotTwoWayTest {

  @DisplayName("이미 왼쪽으로 Line이 만들어진 LeftPoint는 오른쪽으로 Line을 만들 수 없다.")
  @Test
  public void LineStrategyNotTwoWay_notCreateRightLine() {
    LineStrategyNotTwoWay lineStrategy = new LineStrategyNotTwoWay();
    Point leftPoint = new Point();
    leftPoint.createLineWithLeftPoint();

    assertThat(lineStrategy.canCreateLine(leftPoint, new Point())).isFalse();
  }

  @DisplayName("이미 오른쪽으로 Line이 만들어진 rightPoint는 왼쪽으로 Line을 만들 수 없다.")
  @Test
  public void LineStrategyNotTwoWay_notCreateLeftLine() {
    LineStrategyNotTwoWay lineStrategy = new LineStrategyNotTwoWay();
    Point rightPoint = new Point();
    rightPoint.createLineWithRightPoint();

    assertThat(lineStrategy.canCreateLine(new Point(), rightPoint)).isFalse();
  }
}
