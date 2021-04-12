package ladder.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  @DisplayName("[Point] 첫번째 점에서 오른쪽이 연결된 경우 이동, 아닌 경우 그대로")
  void first() {
    assertThat(Point.first(TRUE).move()).isEqualTo(1);
    assertThat(Point.first(FALSE).move()).isEqualTo(0);
  }

  @Test
  @DisplayName("[Point] 연결되지 않은 경우 그대로 해당 index")
  void next_stay() {
    Point second = Point.first(FALSE).next(FALSE);
    /*
    *   user1  user2  user3
    *     |     |     |
    *   user2 그대로 1번 index
    * */
    assertThat(second.move()).isEqualTo(1);
  }

  @Test
  @DisplayName("[Point] 연결된 경우 왼쪽으로 이동, 현재 index - 1")
  void next_left() {
    Point second = Point.first(TRUE).next(FALSE);
    /*
     *   user1  user2  user3
     *     |-----|     |
     *   user2 왼쪽으로 이동
     * */
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  @DisplayName("[Point] 연결된 경우 오른쪽으로 이동, 현재 index + 1")
  void next_right() {
    Point second = Point.first(FALSE).next(TRUE);
    /*
     *   user1  user2  user3
     *     |     |-----|
     *   user2 오른쪽으로 이동
     * */
    assertThat(second.move()).isEqualTo(2);
  }

  @Test
  @DisplayName("[Point] 왼쪽이 연결되어 있다면, 다음은 연결되어 있지 않으므로 왼쪽으로 이동")
  void next() {
    Point second = Point.first(TRUE).next(new RandomConnect());
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  @DisplayName("[Point] 마지막은 항상 연결되어 있지 않음, 연결된 왼쪽으로 이동")
  void next_last() {
    Point second = Point.first(TRUE).last();
    assertThat(second.move()).isEqualTo(0);
  }
}
