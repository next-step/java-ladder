package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

  @ParameterizedTest
  @MethodSource("heightAndNameStrArrProvider")
  void createByHeightAndNamesStrArr(Height height, String namesStr) {
    String[] nameStrArr = namesStr.split(",");

    Ladder ladder = Ladder.createByHeightAndNamesStrArr(height, nameStrArr);

    assertThat(ladder.getLines().size()).isEqualTo(height.getValue());

    for (Line line : ladder.getLines()) {
      assertThat(line.getPoints().size()).isEqualTo(nameStrArr.length);
    }
  }

  public static Stream<Arguments> heightAndNameStrArrProvider() {
    return Stream.of(
        arguments(
            new Height(1),
            "test1, test2, test3, test4"
        ),
        arguments(
            new Height(5),
            "test1, test2, test3, test4"
        ),
        arguments(
            new Height(5),
            "test1, test2, test3, test4, test5, test6, test7"
        )
    );
  }
}