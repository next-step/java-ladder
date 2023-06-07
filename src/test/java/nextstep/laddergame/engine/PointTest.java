package nextstep.laddergame.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

  @DisplayName("왼쪽으로 Line이 있는지 확인한다.")
  @Test
  public void checkLeftWay() {
    Point point = new Point();
    assertAll(
        () -> assertThat(point.checkLeftWay()).isFalse(),
        () -> point.createLineWithLeftPoint(),
        () -> assertThat(point.checkLeftWay()).isTrue()
    );
  }

  @DisplayName("오른쪽으로 Line이 있는지 확인한다.")
  @Test
  public void checkRightWay() {
    Point point = new Point();
    assertAll(
        () -> assertThat(point.checkRightWay()).isFalse(),
        () -> point.createLineWithRightPoint(),
        () -> assertThat(point.checkRightWay()).isTrue()
    );
  }

  @DisplayName("양쪽으로 Line이 있는지 확인한다.")
  @Test
  public void checkTwoWay() {
    Point point = new Point();
    assertAll(
        () -> assertThat(point.checkTwoWay()).isFalse(),
        () -> point.createLineWithRightPoint(),
        () -> assertThat(point.checkTwoWay()).isFalse(),
        () -> point.createLineWithLeftPoint(),
        () -> assertThat(point.checkTwoWay()).isTrue()
    );
  }
}
