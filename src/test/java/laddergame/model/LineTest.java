package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {

  @Test
  void createByCountOfPerson() {
    System.out.println(Line.createByCountOfPerson(5).toString());
  }

  @ParameterizedTest
  @MethodSource("provideLine")
  @DisplayName("이어진 지점 찾기 테스트")
  void getNextPositionAt(Line line, Map<Integer, Integer> resultMap) {
    resultMap.forEach((key, value) -> {
      assertThat(line.getNextPositionAt(key)).isEqualTo(value);
    });
  }

  public static Stream<Arguments> provideLine() {
    BasicPoint basicPoint1 = new BasicPoint(0);
    LinkablePoint basicPoint2 = basicPoint1.createNextWithLinkedBy(true);
//
    return Stream.of(
        arguments(
            new Line(
                Arrays.asList(
                    new BasicPoint(0),
                    new BasicPoint(1)
                )
            ),
            new HashMap<Integer, Integer>() {{
              put(0, 0);
              put(1, 1);
            }}
        ),
        arguments(
            new Line(
                Arrays.asList(
                    basicPoint1,
                    basicPoint2,
                    new BasicPoint(2)
                )
            ),
            new HashMap<Integer, Integer>() {{
              put(0, 1);
              put(1, 0);
              put(2, 2);
            }}
        )
    );
  }
}