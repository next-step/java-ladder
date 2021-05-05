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
  void generate(int height, Position positionOfFirstPlayer, Position positionOfSecondPlayer) {
    // given
    Players players = Players.create("gmoon, guest, test");

    // when
    Ladder generate = Ladder.generate(height, players.totalSize() - 1, LineRule.drawing());
    System.out.println(generate);
    Record actual = Record.generate(players, generate);

    // then
    assertAll(
            () -> assertThat(actual.getPlayerPosition(Player.create("gmoon"))).isEqualTo(positionOfFirstPlayer),
            () -> assertThat(actual.getPlayerPosition(Player.create("guest"))).isEqualTo(positionOfSecondPlayer),
            () -> assertThat(actual.getPlayerPosition(Player.create("test"))).isEqualTo(new Position(2))
    );
  }

  static Stream<Arguments> generateArguments() {
    return Stream.of(
            Arguments.of(1, new Position(1), new Position()),
            Arguments.of(2, new Position(), new Position(1)),
            Arguments.of(3, new Position(1), new Position())
    );
  }
}