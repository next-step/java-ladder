package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RecordTest {

  @ParameterizedTest
  @MethodSource("generateArguments")
  @DisplayName("사다리 결과 기록 테스트, 참고 LineRule.drawing() true, false를 반환한다.")
  void generate(int height, int indexOfFirstPlayer, int indexOfSecondPlayer) {
    // given
    Players players = Players.create("gmoon, guest, test");

    // when
    Record actual = Record.generate(players, Ladder.generate(height, players.totalSize() - 1, LineRule.drawing()));

    // then
    assertAll(
            () -> assertThat(actual.getPlayerIndexOf(Player.create("gmoon"))).isEqualTo(indexOfFirstPlayer),
            () -> assertThat(actual.getPlayerIndexOf(Player.create("guest"))).isEqualTo(indexOfSecondPlayer),
            () -> assertThat(actual.getPlayerIndexOf(Player.create("test"))).isEqualTo(2)
    );
  }

  static Stream<Arguments> generateArguments() {
    return Stream.of(
            Arguments.of(1, 1, 0),
            Arguments.of(2, 0, 1),
            Arguments.of(3, 1, 0)
    );
  }
}