package ladder.model;

import ladder.model.Height;
import ladder.strategy.LadderPointsStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
  LadderPointsStrategy strategy;

  @BeforeEach
  void setup() {
    strategy = () -> true;
  }

  @ParameterizedTest
  @CsvSource(value = "1,4")
  @DisplayName("정확한 높이대로 생성하는 지 테스트")
  void heightTest(int heightKey, int countOfPerson) {
    Ladder ladder = Ladder.makeLines(new Height(heightKey), countOfPerson, strategy);
    assertThat(ladder.specificLines().size()).isEqualTo(heightKey);
  }

  @ParameterizedTest
  @CsvSource(value = "1,4")
  @DisplayName("정확한 사람 수대로 생성하는 지 테스트")
  void personSizeTest(int heightKey, int countOfPerson) {
    Ladder ladder = Ladder.makeLines(new Height(heightKey), countOfPerson, strategy);
    int count = ladder.specificLines()
      .stream()
      .findAny()
      .get()
      .points()
      .size();

    assertThat(count).isEqualTo(countOfPerson);
  }

}
