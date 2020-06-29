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
    Point point0 = new Point(0);
    Point point1 = point0.createNextWithLinkedBy(true);
    Point point2 = new Point(2);
    Point point3 = new Point(3);
    Point point4 = point3.createNextWithLinkedBy(true);

    return Stream.of(
        arguments(
            new Line(
                Arrays.asList(
                    point0,
                    point1,
                    point2,
                    point3,
                    point4
                )
            )
        )
    );
  }
}