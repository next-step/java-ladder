package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PlayerIteratorTest {
  @ParameterizedTest
  @MethodSource("provideIteratorTestParameters")
  void hasNext(List<String> input, boolean result) {
    Players players = Players.from(input);
    assertThat(players.iterator().hasNext()).isEqualTo(result);
  }

  private static Stream<Arguments> provideIteratorTestParameters() {
    return Stream.of(
            Arguments.arguments(List.of("TEST1", "TEST2"), true),
            Arguments.arguments(List.of(), false)
    );
  }

  @Test
  void next() {
    Players players = Players.from(List.of("TEST1", "TEST2"));
    assertThat(players.iterator().next()).isEqualTo(Player.of("TEST1", 0));
  }

  @Test
  void next_예외() {
    Players players = Players.from(List.of());
    assertThatThrownBy(() -> players.iterator().next()).isInstanceOf(IllegalStateException.class);
  }
}
