package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import ladderGame.service.LineLayerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {
  @DisplayName("플래이어수와 사다리높이를 입력해서 사다리 생성.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  void createLadderLayerTest(int height) {
    assertThat(LineLayerGenerator.createLineLayer(height,1).size()).isEqualTo(height);
  }
}