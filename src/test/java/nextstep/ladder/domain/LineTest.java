package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @DisplayName("이전 좌표에 선이 있으면, 현재 좌표에는 선이 존재할 수 없다.")
  @Test
  void getBoolean() {
    assertThat(Line.checkLineByPrevious(true)).isFalse();
  }
}
