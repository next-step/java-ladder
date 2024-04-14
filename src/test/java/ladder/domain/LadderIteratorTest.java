package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderIteratorTest {
  @ParameterizedTest
  @MethodSource("provideIteratorTestParameters")
  void hasNext(int[][] input, boolean result) {
    Ladder ladder = Ladder.from(input);
    Iterator<Row> iterator = ladder.iterator();
    iterator.next();
    assertThat(iterator.hasNext()).isEqualTo(result);
  }

  private static Stream<Arguments> provideIteratorTestParameters() {
    return Stream.of(
            Arguments.arguments(new int [][] {
                    { 0, 1, 0 },
                    { 1, 0, 0 },
                    { 0, 0, 1 }
            }, true),
            Arguments.arguments(new int [][] { {0, 1, 0} }, false)
    );
  }

  @Test
  void next() {
    Ladder ladder = Ladder.from(new int[][]{
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 1}
    });
    assertThat(ladder.iterator().next()).isEqualTo(Row.of(new int[] {0, 1, 0}, 0));
  }

  @Test
  void next_예외() {
    Ladder ladder = Ladder.from(new int[][]{
            {0, 1, 0}
    });
    Iterator<Row> iterator = ladder.iterator();
    iterator.next();
    assertThatThrownBy(iterator::next).isInstanceOf(IllegalStateException.class);
  }
}
