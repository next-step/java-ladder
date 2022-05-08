package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

  @DisplayName("입력된 너비 만큼의 좌표를 가진 Line을 생성할 수 있다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 100})
  void create(int width) {
    Line line = new Line(width);
    assertThat(line.size()).isEqualTo(width);
  }

  @DisplayName("이전 좌표에 선이 있으면, 현재 좌표에는 선이 존재할 수 없다.")
  @Test
  void getBoolean() {
    assertThat(Line.checkLineByPrevious(true)).isFalse();
  }
}
