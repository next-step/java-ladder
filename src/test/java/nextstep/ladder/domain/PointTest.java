package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  @DisplayName("Point를 생성한다.")
  void create() {
    //given
    final boolean pointSource = false;

    //when
    final Point point = new Point(pointSource);

    //then
    assertThat(point).isEqualTo(new Point(pointSource));
  }
}
