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
    LinkablePoint basicPoint0 = BasicPoint.create(0);
    LinkablePoint basicPoint1 = basicPoint0.createNextWithLinkedBy(true);
    LinkablePoint basicPoint2 = BasicPoint.create(2);
    LinkablePoint basicPoint3 = BasicPoint.create(3);
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