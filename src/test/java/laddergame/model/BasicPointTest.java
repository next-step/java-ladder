package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasicPointTest {

  @ParameterizedTest
  @MethodSource("createWithNext")
  void createNextWithLinkedBy(BasicPoint basicPoint) {
    boolean isLinked = true;

    LinkablePoint next = basicPoint.createNextWithLinkedBy(isLinked);

    assertThat(next.getPosition()).isEqualTo(basicPoint.getNextPosition());
  }

  static Stream<Arguments> createWithNext() {
    return Stream.of(
        arguments(
            new BasicPoint(0)
        )
    );
  }

  @ParameterizedTest
  @MethodSource("createNextWithLinkedBy_실패할경우")
  void createNextWithLinkedBy_실패할경우(BasicPoint basicPoint) {
    boolean isLinked = false;

    LinkablePoint next = basicPoint.createNextWithLinkedBy(isLinked);

    assertThat(basicPoint.getPosition()).isEqualTo(basicPoint.getNextPosition());

  }

  static Stream<Arguments> createNextWithLinkedBy_실패할경우() {
    return Stream.of(
        arguments(
            new BasicPoint(0)
        )
    );
  }
}
