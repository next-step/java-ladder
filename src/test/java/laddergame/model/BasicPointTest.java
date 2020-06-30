package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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
            BasicPoint.create(0)
        )
    );
  }

  @ParameterizedTest
  @MethodSource("createNextWithLinkedBy_실패할경우")
  void createNextWithLinkedBy_실패할경우(BasicPoint basicPoint) {
    assertThat(basicPoint.getPosition()).isEqualTo(basicPoint.getNextPosition());
  }

  static Stream<Arguments> createNextWithLinkedBy_실패할경우() {
    return Stream.of(
        arguments(
            BasicPoint.create(0)
        )
    );
  }

  @Test
  void createNext() {
    LinkablePoint linkedPoint = BasicPoint.create(0).createNextWithLinkedBy(true);

    assertThat(linkedPoint.createNext().getNextPosition())
        .isEqualTo(linkedPoint.createNext().getPosition());

  }
}
