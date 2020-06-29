package laddergame.model;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineDTOTest {

  @ParameterizedTest
  @MethodSource("DTO변환테스트")
  void DTO변환테스트(Line line) {
    LineDTO lineDTO = LineDTO.createBy(line);

    System.out.println(lineDTO.toString());
    System.out.println(lineDTO.getLineWithMappedPoint());
  }

  static Stream<Arguments> DTO변환테스트() {
    BasicPoint basicPoint0 = new BasicPoint(0);
    LinkablePoint basicPoint1 = basicPoint0.createNextWithLinkedBy(true);
    BasicPoint basicPoint2 = new BasicPoint(2);
    BasicPoint basicPoint3 = new BasicPoint(3);
    LinkablePoint basicPoint4 = basicPoint3.createNextWithLinkedBy(true);

    return Stream.of(
        arguments(
            new Line(
                Arrays.asList(
                    basicPoint0,
                    basicPoint1,
                    basicPoint2,
                    basicPoint3,
                    basicPoint4
                )
            )
        )
    );
  }
}