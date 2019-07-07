package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    Point point = Point.of(1, false, true);
    assertThat(point.move()).isEqualTo(2);
  }

  @DisplayName("좌측방향 이동")
  @Test
  void move_left() {
    Point point = Point.of(1, true, false);
    assertThat(point.move()).isEqualTo(0);
  }

  @DisplayName("첫 번째 위치에 좌측 true 예외처리")
  @Test
  void move_exception() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Point.of(0, true, false));
  }
}
