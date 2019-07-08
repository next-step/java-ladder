package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

  @DisplayName("생성 테스트")
  @Test
  void create() {
    Point point = Point.first(false);
    assertThat(point.move()).isEqualTo(0);
  }

  @DisplayName("우측방향으로 이동")
  @Test
  void move_right() {
    Point point = Point.first(false).next(true);
    assertThat(point.move()).isEqualTo(2);
  }

  @DisplayName("좌측방향 이동")
  @Test
  void move_left() {
    Point point = Point.first(true).next(true);
    assertThat(point.move()).isEqualTo(0);
  }

  @DisplayName("마지막 지점")
  @Test
  void last() {
    Point point = Point.first(true).last();
    assertThat(point.move()).isEqualTo(0);
  }
}
