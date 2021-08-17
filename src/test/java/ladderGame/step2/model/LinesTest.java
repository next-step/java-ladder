package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {
  @DisplayName("플래이어수와 사다리높이를 입력해서 사다리 생성.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  void createLadderLayerTest(int height) {
    Lines lines = new Lines(height, 1);

    assertThat(lines.toList().get(0)).isEqualTo(new Line(1));
    assertThat(lines.toList().size()).isEqualTo(height);
  }
}