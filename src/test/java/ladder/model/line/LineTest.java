package ladder.model.line;

import ladder.strategy.LadderPointsStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    LadderPointsStrategy strategy = new LadderPointsStrategy() {
      @Override
      public boolean makeFirstPoint() {
        return false;
      }

      @Override
      public boolean makeMiddlePoints(boolean leftPoint) {
        return false;
      }

      @Override
      public boolean makeLastPoint() {
        return false;
      }
    };

    int pointSize = new Line(2, strategy).points().specificPoints().size();

    Assertions.assertThat(pointSize).isEqualTo(2);
  }

}
