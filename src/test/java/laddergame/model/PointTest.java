package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {

  @ParameterizedTest
  @MethodSource("providePoint")
  void hasNextPoint(Point point, boolean expected) {
    assertThat(point.hasLinkedPoint()).isEqualTo(expected);
  }

  static Stream<Arguments> providePoint() {
    return Stream.of(
        arguments(
            new Point(0),
            false
        ),
        arguments(
            new Point(0, new Point(1)),
            true
        )
    );
  }

  @ParameterizedTest
  @MethodSource("createWithNext")
  void createNextWithLinkedBy(Point point) {
    boolean isLinked = true;

    Point next = point.createNextWithLinkedBy(isLinked);

    assertThat(next.hasLinkedPoint()).isEqualTo(isLinked);
    assertThat(next.getPosition()).isEqualTo(point.getNextPosition());
  }

  static Stream<Arguments> createWithNext() {
    return Stream.of(
        arguments(
            new Point(0)
        )
    );
  }

  @ParameterizedTest
  @MethodSource("createNextWithLinkedBy_실패할경우")
  void createNextWithLinkedBy_실패할경우(Point point) {
    boolean isLinked = false;

    Point next = point.createNextWithLinkedBy(isLinked);

    assertThat(next.hasLinkedPoint()).isEqualTo(isLinked);
    assertThat(point.getPosition()).isEqualTo(point.getNextPosition());

  }

  static Stream<Arguments> createNextWithLinkedBy_실패할경우() {
    return Stream.of(
        arguments(
            new Point(0)
        )
    );
  }
}
