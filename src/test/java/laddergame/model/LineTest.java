package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

  @ParameterizedTest
  @CsvSource({
      "1",
      "2"
  })
  void getPoints_길이테스트(int countOfPerson) {
    Line line = Line.createByCountOfPerson(countOfPerson);

    assertThat(line.getPoints().size()).isEqualTo(countOfPerson);
  }

  @ParameterizedTest
  @CsvSource({
      "1",
      "2",
      "3",
      "4",
      "20"
  })
  void getPoints_true중복테스트(int countOfPerson) {
    Line line = Line.createByCountOfPerson(countOfPerson);
    int cnt = 0;

    for (Point point : line.getPoints()) {
      cnt++;

      if (!point.isRungCreated()) {
        cnt = 0;
      }

      assertThat(cnt).isNotEqualTo(2);
    }

    System.out.println(line.getPoints());
  }
}