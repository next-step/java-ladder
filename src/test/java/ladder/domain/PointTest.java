package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  @DisplayName("[Point] boolean 값에 따른 Point 반환 테스트")
  void getPointTest() {
    assertThat(Point.getPoint(true)).isEqualTo(Point.CONNECT);
    assertThat(Point.getPoint(false)).isEqualTo(Point.DISCONNECT);
  }
}
