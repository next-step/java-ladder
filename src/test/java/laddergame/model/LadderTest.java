package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

  @ParameterizedTest
  @CsvSource({
      "1, 1",
      "5, 5",
      "100, 100"
  })
  void createByHeightAndCountOfPerson(int height, int countOfPerson) {
    Ladder ladder = Ladder.createByHeightAndCountOfPerson(height, countOfPerson);

    assertThat(ladder.getLines().size()).isEqualTo(height);

    for (Line line : ladder.getLines()) {
      assertThat(line.getPoints().size()).isEqualTo(countOfPerson);
    }
  }
}