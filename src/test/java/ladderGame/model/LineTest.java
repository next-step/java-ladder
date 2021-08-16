package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLineTest() {
    assertThat(new Line(1)).isEqualTo(new Line(1));
  }

  @DisplayName("사다리 시작하는 노드의 기본값 false 생성 테스트.")
  @Test
  void checkFirstLineIsFalse() {
    assertThat(new Line(1).getPoints().get(0)).isEqualTo(false);
  }
}