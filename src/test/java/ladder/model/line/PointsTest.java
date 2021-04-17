package ladder.model.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ladder.strategy.LadderPointsStrategy;

class PointsTest {
  LadderPointsStrategy strategy;
  @BeforeEach
  void setup(){
    strategy = new LadderPointsStrategy() {
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
  }

  @ParameterizedTest
  @CsvSource(value = "4")
  @DisplayName("포인트 생성 테스트")
  void validLineMakingTest(int countOfPerson){
    Points points = Points.makePoints(countOfPerson, strategy);

    Assertions.assertThat(points.specificPoints().size()).isEqualTo(countOfPerson);
  }
}