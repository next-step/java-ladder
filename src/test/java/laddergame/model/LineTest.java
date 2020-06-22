package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

  @ParameterizedTest
  @MethodSource("lineWithPositionProvider")
  @DisplayName("좌우에 다리가 있는지 확인")
  void hasRungAt(Line line, List<Boolean> expected) {
    for (int i = 0; i < line.getPoints().size(); i++) {
      assertThat(line.hasRungAt(i))
          .isEqualTo(expected.get(i));
    }
  }

  public static Stream<Arguments> lineWithPositionProvider() {
    return Stream.of(
        arguments(
            new Line(
                Arrays.asList(
                    new Point(false),
                    new Point(false)
                )
            ),
            Arrays.asList(
                false, false
            )
        ),
        arguments(
            new Line(
                Arrays.asList(
                    new Point(false),
                    new Point(true),
                    new Point(true)
                )
            ),
            Arrays.asList(
                false, true, true
            )
        )
    );
  }
}