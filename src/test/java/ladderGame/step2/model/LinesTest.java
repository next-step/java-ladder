package ladderGame.step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladderGame.step2.service.LineLayerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinesTest {
  @DisplayName("플래이어수와 사다리높이를 입력해서 사다리 생성.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4})
  void createLadderLayerTest(int height) {

    List<Line> lineLayer = LineLayerGenerator.createLineLayer(height, 1);

    assertThat(lineLayer.get(0)).isEqualTo(new Line(1));
    assertThat(lineLayer.size()).isEqualTo(height);
  }
}