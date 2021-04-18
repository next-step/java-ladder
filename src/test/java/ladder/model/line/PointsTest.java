package ladder.model.line;

import ladder.model.result.InterimResults;
import ladder.strategy.LadderPointsStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointsTest {
  LadderPointsStrategy strategy;

  @BeforeEach
  void setup() {
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
  void validLineMakingTest(int countOfPerson) {
    Points points = Points.makePoints(countOfPerson, strategy);

    Assertions.assertThat(points.specificPoints().size()).isEqualTo(countOfPerson);
  }

  @Test
  @DisplayName("포인트 이동 테스트")
  void movingTest() {
    Points points = Points.makePoints(4, new LadderPointsStrategy() {
      @Override
      public boolean makeFirstPoint() {
        return true;
      }

      @Override
      public boolean makeMiddlePoints(boolean leftPoint) {
        return true;
      }

      @Override
      public boolean makeLastPoint() {
        return false;
      }
    });

    InterimResults interimResults = InterimResults.makeInterimResults(2);
    InterimResults movedResult = points.move(interimResults);
    Assertions.assertThat(movedResult.interimResults().get(0).resultIndex()).isEqualTo(1);
  }

  @Test
  @DisplayName("포인트 정지 테스트")
  void stoppingTest() {
    Points points = Points.makePoints(4, strategy);

    InterimResults interimResults = InterimResults.makeInterimResults(2);
    InterimResults movedResult = points.move(interimResults);
    Assertions.assertThat(movedResult.interimResults().get(0).resultIndex()).isEqualTo(0);
  }
}