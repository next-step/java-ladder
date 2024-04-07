package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class PlayerTest {
  @ParameterizedTest
  @ValueSource(strings = { "abcdef", "" })
  @NullSource
  void 이름_제한조건_어길_시_예외(String input) {
    assertThatThrownBy(() -> Player.of(input, 0))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = { "A", "AB", "ABC", "ABCD", "ABCDE" })
  void 정상_생성(String input) {
    Player.of(input, 0);
  }

  @ParameterizedTest
  @MethodSource("provideMoveTestParameters")
  void 이동(int[][] input, int result) {
    Player player = Player.of("TEST", 0);
    Ladder ladder = Ladder.from(input);
    assertThat(player.move(ladder)).isEqualTo(result);
  }

  private static Stream<Arguments> provideMoveTestParameters() {
    return Stream.of(
            arguments(new int[][]{
                    {0, 1},
                    {1, 0},
                    {0, 0},
            }, 1),
            arguments(new int[][]{
                    { 1, 0, 1 },
                    { 1, 0, 0 },
                    { 0, 0, 0 },
            }, 0),
            arguments(new int[][]{
                    { 1, 0, 0 },
                    { 0, 1, 0 },
                    { 0, 0, 1 },
            }, 3)
    );
  }

  @Test
  void 이름_반환() {
    Player player = Player.of("TEST", 0);
    assertThat(player.name()).isEqualTo("TEST");
  }
}
