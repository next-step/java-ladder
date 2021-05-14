package nextstep.laddergame.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

class PointTest {
  @Test
  @DisplayName("Direction과 Position을 통해서 Point를 생성한다")
  void create() {
    Direction direction = Direction.first(false).next(false);
    Point point = new Point(0, direction);
    assertEquals(point.move(), 0);
  }

  @Test
  @DisplayName("first() 메서드를 통해서 초기 값을 설정할 수 있다")
  void first() {
    Point falseCase = Point.first(FALSE);
    Point trueCase = Point.first(TRUE);

    assertAll(
        () -> assertEquals(trueCase.move(), 1),
        () -> assertEquals(falseCase.move(), 0)
    );
  }

  @Test
  @DisplayName("move() 함수를 통해서 index를 이동 할 수 있다")
  void move() {
    Point point = Point.first(TRUE);
    assertEquals(point.move(), 1);
  }

  @Test
  @DisplayName("Point의 양쪽 값이 FALSE FALSE일 경우 다음 라인으로 position을 그대로 둔다")
  public void next_stay() {
    Point point = Point.first(FALSE).next(FALSE);
    assertEquals(point.move(), 1);
  }

  @Test
  @DisplayName("Point의 양쪽 값이 TRUE FALSE일 경우 position은 왼쪽으로 이동하기에 감소한다")
  public void next_left() {
    Point point = Point.first(TRUE).next(FALSE);
    assertEquals(point.move(), 0);
  }

  @Test
  @DisplayName("Point의 양쪽 값이 FALSE TRUE일 경우 position은 오른쪽으로 이동하기에 증가한다")
  public void next_right() {
    Point point = Point.first(FALSE).next(TRUE);
    assertEquals(point.move(), 2);
  }

}