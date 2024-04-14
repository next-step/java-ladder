package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowIteratorTest {
  @ParameterizedTest
  @MethodSource("provideIteratorTestParameters")
  void hasNext(int[] input, boolean result) {
    Row row = Row.of(input, 0);
    Iterator<Point> iterator = row.iterator();
    IntStream.range(0, 2)
            .forEach(i -> iterator.next());
    assertThat(iterator.hasNext()).isEqualTo(result);
  }

  private static Stream<Arguments> provideIteratorTestParameters() {
    return Stream.of(
            Arguments.arguments(new int[]{0, 1}, true),
            Arguments.arguments(new int[]{0}, false)
    );
  }

  @Test
  void next() {
    Row row = Row.of(new int[]{0, 1}, 0);
    Iterator<Point> iterator = row.iterator();
    assertThat(iterator.next()).isEqualTo(Point.first(0, false, sides -> Direction.RIGHT));
  }

  @Test
  void next_예외() {
    Row row = Row.of(new int[]{0}, 0);
    Iterator<Point> iterator = row.iterator();
    IntStream.range(0, 2)
            .forEach(i -> iterator.next());
    assertThatThrownBy(iterator::next).isInstanceOf(IllegalStateException.class);
  }
}
