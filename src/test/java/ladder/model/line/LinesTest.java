package ladder.model.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ladder.model.Height;
import ladder.strategy.LadderPointsStrategy;

import static org.assertj.core.api.Assertions.*;

class LinesTest {
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
  @CsvSource(value = "1,4")
  @DisplayName("정확한 높이대로 생성하는 지 테스트")
  void heightTest(int heightKey, int countOfPerson) {
    Lines lines = Lines.makeLines(new Height(heightKey), countOfPerson, strategy);
    assertThat(lines.specificLines().size()).isEqualTo(heightKey);
  }

  @ParameterizedTest
  @CsvSource(value = "1,4")
  @DisplayName("정확한 사람 수대로 생성하는 지 테스트")
  void personSizeTest(int heightKey, int countOfPerson) {
    Lines lines = Lines.makeLines(new Height(heightKey), countOfPerson, strategy);
    int count = lines.specificLines()
      .stream()
      .findAny()
      .get()
      .points().specificPoints()
      .size();

    assertThat(count).isEqualTo(countOfPerson);
  }

}
